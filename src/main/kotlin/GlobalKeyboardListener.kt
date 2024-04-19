import com.icuxika.jextract.win32.HOOKPROC
import com.icuxika.jextract.win32.KBDLLHOOKSTRUCT
import com.icuxika.jextract.win32.ffm_h.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import kotlin.concurrent.thread

class GlobalKeyboardListener {

    private lateinit var hook: MemorySegment
    private var currentThreadId: Int = 0

    fun hook() {
        thread {
            currentThreadId = GetCurrentThreadId()
            Arena.ofConfined().use { arena ->
                hook = SetWindowsHookExW(WH_KEYBOARD_LL(), HOOKPROC.allocate({ code, wParam, lParam ->
                    val kbDllHookStruct = KBDLLHOOKSTRUCT.ofAddress(
                        MemorySegment.ofAddress(lParam),
                        arena
                    )
                    val vkCode = KBDLLHOOKSTRUCT.`vkCode$get`(kbDllHookStruct)
                    if (vkCode >= 0) {
                        if (wParam == WM_KEYDOWN().toLong()) {
                            println("按下->${vkCode}")
                        } else if (wParam == WM_KEYUP().toLong()) {
                            println("松开->${vkCode}")
                        }
                    }
                    CallNextHookEx(hook, code, wParam, lParam)
                }, arena), MemorySegment.NULL, 0)
                println("hook")
                while (GetMessageW(arena.allocate(LPMSG), MemorySegment.NULL, 0, 0) != 0) {
                }
                UnhookWindowsHookEx(hook)
                println("unhook")
            }
        }
    }

    /**
     * 向GetMessageW创建的消息队列发送结束信号，使while循环结束，然后执行卸载全局键盘事件监听钩子
     */
    fun stop() {
        PostThreadMessageW(currentThreadId, WM_QUIT(), 0, 0)
    }

    /**
     * 卸载全局键盘事件监听钩子，但是GetMessageW创建的消息队列不会退出，合理的方式是调用[stop]
     */
    fun unhook() {
        UnhookWindowsHookEx(hook)
    }
}