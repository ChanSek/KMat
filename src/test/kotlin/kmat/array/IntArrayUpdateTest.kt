package kmat.array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class IntArrayUpdateTest {

    @Test
    fun `range set inclusively`() {
        val arr = IntArray(10) { it }
        arr[3..7] = 20
        assertArrayEquals(intArrayOf(0, 1, 2, 20, 20, 20, 20, 20, 8, 9), arr)
    }

    @Test
    fun `range set exclusively`() {
        val arr = IntArray(10) { it }
        arr[3 until 7] = 20
        assertArrayEquals(intArrayOf(0, 1, 2, 20, 20, 20, 20, 7, 8, 9), arr)
    }

    @Test
    fun `out of range set throws exception`() {
        val arr = IntArray(10) { it * it }
        assertThrows(IndexOutOfBoundsException::class.java) {
            arr[3 until 20] = 30
        }
    }

    @Test
    fun `invalid range set should not do anything`() {
        val arr = IntArray(10) { it * it }
        arr[7 until 3] = 34
        assertArrayEquals(IntArray(10) { it * it }, arr)
    }
}
