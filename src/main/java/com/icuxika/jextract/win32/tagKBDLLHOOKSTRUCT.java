// Generated by jextract

package com.icuxika.jextract.win32;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct tagKBDLLHOOKSTRUCT {
 *     DWORD vkCode;
 *     DWORD scanCode;
 *     DWORD flags;
 *     DWORD time;
 *     ULONG_PTR dwExtraInfo;
 * };
 *}
 */
public class tagKBDLLHOOKSTRUCT {

    public static MemoryLayout $LAYOUT() {
        return constants$0.const$5;
    }

    public static VarHandle vkCode$VH() {
        return constants$1.const$0;
    }

    /**
     * Getter for field:
     * {@snippet :
     * DWORD vkCode;
     *}
     */
    public static int vkCode$get(MemorySegment seg) {
        return (int) constants$1.const$0.get(seg);
    }

    /**
     * Setter for field:
     * {@snippet :
     * DWORD vkCode;
     *}
     */
    public static void vkCode$set(MemorySegment seg, int x) {
        constants$1.const$0.set(seg, x);
    }

    public static int vkCode$get(MemorySegment seg, long index) {
        return (int) constants$1.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void vkCode$set(MemorySegment seg, long index, int x) {
        constants$1.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle scanCode$VH() {
        return constants$1.const$1;
    }

    /**
     * Getter for field:
     * {@snippet :
     * DWORD scanCode;
     *}
     */
    public static int scanCode$get(MemorySegment seg) {
        return (int) constants$1.const$1.get(seg);
    }

    /**
     * Setter for field:
     * {@snippet :
     * DWORD scanCode;
     *}
     */
    public static void scanCode$set(MemorySegment seg, int x) {
        constants$1.const$1.set(seg, x);
    }

    public static int scanCode$get(MemorySegment seg, long index) {
        return (int) constants$1.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void scanCode$set(MemorySegment seg, long index, int x) {
        constants$1.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle flags$VH() {
        return constants$1.const$2;
    }

    /**
     * Getter for field:
     * {@snippet :
     * DWORD flags;
     *}
     */
    public static int flags$get(MemorySegment seg) {
        return (int) constants$1.const$2.get(seg);
    }

    /**
     * Setter for field:
     * {@snippet :
     * DWORD flags;
     *}
     */
    public static void flags$set(MemorySegment seg, int x) {
        constants$1.const$2.set(seg, x);
    }

    public static int flags$get(MemorySegment seg, long index) {
        return (int) constants$1.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void flags$set(MemorySegment seg, long index, int x) {
        constants$1.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle time$VH() {
        return constants$1.const$3;
    }

    /**
     * Getter for field:
     * {@snippet :
     * DWORD time;
     *}
     */
    public static int time$get(MemorySegment seg) {
        return (int) constants$1.const$3.get(seg);
    }

    /**
     * Setter for field:
     * {@snippet :
     * DWORD time;
     *}
     */
    public static void time$set(MemorySegment seg, int x) {
        constants$1.const$3.set(seg, x);
    }

    public static int time$get(MemorySegment seg, long index) {
        return (int) constants$1.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void time$set(MemorySegment seg, long index, int x) {
        constants$1.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle dwExtraInfo$VH() {
        return constants$1.const$4;
    }

    /**
     * Getter for field:
     * {@snippet :
     * ULONG_PTR dwExtraInfo;
     *}
     */
    public static long dwExtraInfo$get(MemorySegment seg) {
        return (long) constants$1.const$4.get(seg);
    }

    /**
     * Setter for field:
     * {@snippet :
     * ULONG_PTR dwExtraInfo;
     *}
     */
    public static void dwExtraInfo$set(MemorySegment seg, long x) {
        constants$1.const$4.set(seg, x);
    }

    public static long dwExtraInfo$get(MemorySegment seg, long index) {
        return (long) constants$1.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void dwExtraInfo$set(MemorySegment seg, long index, long x) {
        constants$1.const$4.set(seg.asSlice(index * sizeof()), x);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemorySegment addr, Arena arena) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, arena);
    }
}

