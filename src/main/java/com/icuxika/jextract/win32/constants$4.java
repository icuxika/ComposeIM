// Generated by jextract

package com.icuxika.jextract.win32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

final class constants$4 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$4() {
    }

    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_INT,
            RuntimeHelper.POINTER
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
            "UnhookWindowsHookEx",
            constants$4.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(JAVA_LONG,
            RuntimeHelper.POINTER,
            JAVA_INT,
            JAVA_LONG,
            JAVA_LONG
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
            "CallNextHookEx",
            constants$4.const$2
    );
}


