package kmat.array

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class IArrayTest {

    @Test
    fun `array creation through varargs`() {
        val arr = iArrayOf(2, 3, 5, 7)
        val intArr = intArrayOf(2, 3, 5, 7)
        val iArr = iArrayOf(2, 3, 5, 7)
        assertEquals(arr, intArr)
        assertEquals(arr, iArr)
    }

    @Test
    fun `array creation through constructor`() {
        var arr = IArray(10)
        var intArr = IntArray(10)
        assertEquals(arr, intArr)
        assertEquals(arr, intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        arr = IArray(10) { it }
        intArr = IntArray(10) { it }
        assertEquals(arr, intArr)

        arr = IArray(3) { it * it }
        intArr = intArrayOf(0, 1, 4)
        val iArr = iArrayOf(0, 1, 4)
        assertEquals(arr, intArr)
        assertEquals(arr, iArr)
    }
}
