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
import composeim.generated.resources.Res
import composeim.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.splitpane.ExperimentalSplitPaneApi
import org.jetbrains.compose.splitpane.HorizontalSplitPane
import org.jetbrains.compose.splitpane.VerticalSplitPane
import org.jetbrains.compose.splitpane.rememberSplitPaneState
import ui.theme.AppTheme
import ui.theme.ComposeIMTheme
import java.awt.Cursor

@OptIn(ExperimentalSplitPaneApi::class, ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    val systemTheme = !isSystemInDarkTheme()
    var isDarkTheme by remember { mutableStateOf(systemTheme) }

    var theme by remember { mutableStateOf(ComposeIMTheme.Theme.Light) }

    var text by remember { mutableStateOf("Hello, World!") }

    val splitterState = rememberSplitPaneState()
    val hSplitterState = rememberSplitPaneState()

    AppTheme(theme) {
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
                        theme = when (theme) {
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
                }

                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
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
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
