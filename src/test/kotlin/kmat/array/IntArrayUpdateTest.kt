package kmat.array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException

class IntArrayUpdateTest {

    @Test
    fun `range set inclusively`() {
        val arr = IntArray(10) { it }
        arr[3..7] = 20
        Assertions.assertArrayEquals(intArrayOf(0, 1, 2, 20, 20, 20, 20, 20, 8, 9), arr)
    }

    @Test
    fun `range set exclusively`() {
        val arr = IntArray(10) { it }
        arr[3 until 7] = 20
        Assertions.assertArrayEquals(intArrayOf(0, 1, 2, 20, 20, 20, 20, 7, 8, 9), arr)
    }

    @Test
    fun `out of range set throws exception`() {
        val arr = IntArray(10) { it * it }
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            arr[3 until 20] = 30
        }
    }

    @Test
    fun `invalid range set should not do anything`() {
        val arr = IntArray(10) { it * it }
        arr[7 until 3] = 34
        Assertions.assertArrayEquals(IntArray(10) { it * it }, arr)
    }
}
