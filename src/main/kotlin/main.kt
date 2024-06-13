import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.viewmodel.compose.viewModel
import composeim.generated.resources.Res
import composeim.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.VerticalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState
import ui.theme.AppTheme
import ui.theme.ComposeIMTheme
import util.FileDownloader
import java.awt.Cursor
import java.nio.file.Path

@OptIn(ExperimentalSplitPaneApi::class)
@Composable
@Preview
fun App(viewModel: AppViewModel = viewModel { AppViewModel() }) {
    val systemTheme = !isSystemInDarkTheme()
    var isDarkTheme by remember { mutableStateOf(systemTheme) }

    var text by remember { mutableStateOf("Hello, World!") }

    val splitterState = rememberSplitPaneState()
    val hSplitterState = rememberSplitPaneState()

    var progress by remember { mutableStateOf(0.45f) }
    val scope = rememberCoroutineScope()

    AppTheme(viewModel.theme) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row {
                Column(Modifier.width(48.dp).fillMaxHeight().background(ComposeIMTheme.colors.background)) {
                    Button(
                        onClick = { text = "Hello, Desktop!" },
                        modifier = Modifier.testTag("button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ComposeIMTheme.colors.primary,
                            contentColor = ComposeIMTheme.colors.text
                        )
                    ) {
                        Text(text)
                    }

                    IconButton(onClick = {
                        viewModel.theme = when (viewModel.theme) {
                            ComposeIMTheme.Theme.Light -> ComposeIMTheme.Theme.Dark
                            ComposeIMTheme.Theme.Dark -> ComposeIMTheme.Theme.Undefined
                            ComposeIMTheme.Theme.Undefined -> ComposeIMTheme.Theme.Light
                        }
                    }) {
                        Image(
                            painterResource("theme.svg"),
                            "theme",
                            Modifier.background(ComposeIMTheme.colors.text)
                        )
                    }

                    Image(
                        painterResource(Res.drawable.compose_multiplatform),
                        "compose-multiplatform",
                        Modifier.background(ComposeIMTheme.colors.text)
                    )

                    Button(onClick = {
                        scope.launch {
                            val fileURL =
                                "https://dldir1.qq.com/qqfile/qq/QQNT/Windows/QQ_9.9.9_240403_x64_01.exe"
                            val filePath =
                                Path.of(System.getProperty("user.home")).resolve("Downloads").resolve("temp")
                                    .resolve("result1.exe");
                            FileDownloader.downloadFile(fileURL, filePath).collect {
                                when (it) {
                                    is FileDownloader.DownloadState.Downloading -> {
                                        progress = it.progress
                                    }

                                    is FileDownloader.DownloadState.Success -> {
                                        println("下载完成[${Thread.currentThread().name}]-->${it.result}")
                                    }

                                    is FileDownloader.DownloadState.Error -> {
                                        println("下载失败[${Thread.currentThread().name}]-->${it.throwable.message}")
                                    }
                                }
                            }
                        }
                    }) {
                        Text("下载")
                    }
                }

                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    LinearProgressIndicator(
                        progress = {
                            progress
                        },
                        modifier = Modifier.fillMaxWidth().height(24.dp).defaultMinSize(minHeight = 24.dp),
                        color = Color.Blue
                    )
                    HorizontalSplitPane(
                        splitPaneState = splitterState
                    ) {
                        first(140.dp) {
                            Box(Modifier.background(MaterialTheme.colorScheme.primaryContainer).fillMaxSize())
                        }
                        second(140.dp) {
                            VerticalSplitPane(splitPaneState = hSplitterState) {
                                first(50.dp) {
                                    Box(Modifier.background(MaterialTheme.colorScheme.onSecondary).fillMaxSize())
                                }
                                second(20.dp) {
                                    Box(Modifier.background(MaterialTheme.colorScheme.onSecondary).fillMaxSize())
                                }
                                splitter {
                                    visiblePart {
                                        Box(
                                            Modifier
                                                .height(2.dp)
                                                .fillMaxWidth()
                                                .background(MaterialTheme.colorScheme.outline)
                                        )
                                    }
                                    handle {
                                        Box(
                                            Modifier
                                                .markAsHandle()
                                                .cursorForVerticalResize()
                                                .background(SolidColor(Color.Gray), alpha = 0.50f)
                                                .fillMaxWidth()
                                                .height(8.dp)
                                        )
                                    }
                                }
                            }
                        }
                        splitter {
                            visiblePart {
                                Box(
                                    Modifier
                                        .width(2.dp)
                                        .fillMaxHeight()
                                        .background(MaterialTheme.colorScheme.outline)
                                )
                            }
                            handle {
                                Box(
                                    Modifier
                                        .markAsHandle()
                                        .cursorForHorizontalResize()
                                        .background(SolidColor(Color.Gray), alpha = 0.50f)
                                        .width(8.dp)
                                        .fillMaxHeight()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun Modifier.cursorForHorizontalResize(): Modifier =
    pointerHoverIcon(PointerIcon(Cursor(Cursor.E_RESIZE_CURSOR)))

private fun Modifier.cursorForVerticalResize(): Modifier =
    pointerHoverIcon(PointerIcon(Cursor(Cursor.N_RESIZE_CURSOR)))

fun main() = application {
    val globalKeyboardListener = GlobalKeyboardListener()
    // 挂载全局键盘事件监听钩子
    globalKeyboardListener.hook()

    var isOpen by remember { mutableStateOf(true) }

    if (isOpen) {
        Window(onCloseRequest = {
            // 窗口关闭时，卸载全局键盘事件监听钩子
            globalKeyboardListener.stop()
            isOpen = false
            exitApplication()
        }) {
            App()
        }
    }
}
