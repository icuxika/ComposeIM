// Generated by jextract

package com.icuxika.jextract.win32;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * typedef LRESULT (*HOOKPROC)(int, WPARAM, LPARAM) __attribute__((stdcall))
 * }
 */
public class HOOKPROC {

    HOOKPROC() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        long apply(int code, long wParam, long lParam);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
        ffm_h.C_LONG_LONG,
        ffm_h.C_INT,
        ffm_h.C_LONG_LONG,
        ffm_h.C_LONG_LONG
    );

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH = ffm_h.upcallHandle(HOOKPROC.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(HOOKPROC.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static long invoke(MemorySegment funcPtr,int code, long wParam, long lParam) {
        try {
            return (long) DOWN$MH.invokeExact(funcPtr, code, wParam, lParam);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}

