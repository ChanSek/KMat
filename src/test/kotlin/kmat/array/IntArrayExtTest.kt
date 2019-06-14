package kmat.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException
import java.util.*

class IntArrayExtTest {

    @Test
    fun `range access inclusively`() {
        val arr = IntArray(10) { it }
        val subArray = arr[3..7]
        assertArrayEquals(intArrayOf(3, 4, 5, 6, 7), subArray)
    }

    @Test
    fun `range access inclusively failure`() {
        val arr = intArrayOf(2, 5, 7, 8, 9, 10, 23)
        val subArray = arr[2..5]
        val expectedArray = intArrayOf(7, 8, 9)
        val equals = Arrays.equals(subArray, expectedArray)
        assertNotEquals(true, equals)
    }

    @Test
    fun `range access exclusively`() {
        val arr = IntArray(10) { it * it }
        val subArray = arr[3 until 7]
        assertArrayEquals(intArrayOf(9, 16, 25, 36), subArray)
    }

    @Test
    fun `out of range access should throw exception`() {
        val arr = IntArray(10) { it * it }
        assertThrows(IndexOutOfBoundsException::class.java) {
            arr[3..20]
        }
    }

    @Test
    fun `invalid range access should return empty array`() {
        val arr = IntArray(10) { it }
        assertArrayEquals(intArrayOf(), arr[3..1])
    }

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

    @Test
    fun `adding a value to each element of array`() {
        val arr = intArrayOf(2, 5, 7)
        val resultArr = arr + 10
        assertArrayEquals(resultArr, intArrayOf(12, 15, 17))
    }

    @Test
    fun `transpose of a row vector`() {
        val arr = intArrayOf(2, 5, 7)
        val result = arr.transpose()
        assertArrayEquals(result, arrayOf(
            intArrayOf(2),
            intArrayOf(5),
            intArrayOf(7)
        ))
    }

    @Test
    fun `transpose of an empty row vector should return empty`() {
        val arr = intArrayOf()
        val result = arr.transpose()
        assertArrayEquals(result, arrayOf())
    }
}
