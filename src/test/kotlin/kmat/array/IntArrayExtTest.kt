@file:Suppress("EmptyRange")

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

        arr += 10
        assertArrayEquals(arr, intArrayOf(12, 15, 17))
    }

    @Test
    fun `adding two integer arrays`() {
        val arr1 = intArrayOf(2, 5, 7)
        val arr2 = intArrayOf(10, 20, 30)
        assertArrayEquals(intArrayOf(12, 25, 37), arr1 + arr2)

        val arr3 = intArrayOf()
        assertThrows(DifferentArrayLengthException::class.java) {
            arr1 + arr3
        }

        val arr4 = intArrayOf(1, 2, 3)
        assertArrayEquals(intArrayOf(13, 27, 40), arr1 + arr2 + arr4)
    }

    @Test
    fun `multiplying a value to each element of array`() {
        val arr = intArrayOf(2, 5, 7)
        val resultArr = arr * 10
        assertArrayEquals(resultArr, intArrayOf(20, 50, 70))

        arr *= 10
        assertArrayEquals(arr, intArrayOf(20, 50, 70))
    }

    @Test
    fun `multiplying a matrix with an array`() {
        val arr = intArrayOf(2, 5, 7)
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3)
        )
        val result = arr * matrix
        assertEquals(33, result)

        val arr2 = intArrayOf(2, 5, 7, 6)
        assertThrows(DifferentArrayLengthException::class.java) {
            arr2 * matrix
        }

        val matrix2: Array<IntArray> = arrayOf()
        assertThrows(DifferentArrayLengthException::class.java) {
            arr2 * matrix2
        }
    }

    @Test
    fun `dividing a value to each element of array`() {
        val arr = intArrayOf(2, 5, 7)
        val resultArr = arr / 2
        assertArrayEquals(resultArr, intArrayOf(1, 2, 3))

        arr /= 2
        assertArrayEquals(arr, intArrayOf(1, 2, 3))
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

        val arr2 = intArrayOf(10, 20, 30)
        val result2 = arr2.T
        assertArrayEquals(result2, arrayOf(
            intArrayOf(10),
            intArrayOf(20),
            intArrayOf(30)
        ))
    }

    @Test
    fun `transpose of an empty row vector should return empty`() {
        val arr = intArrayOf()
        val result = arr.transpose()
        assertArrayEquals(result, arrayOf())
    }

    @Test
    fun `concatenation of two arrays horizontally`() {
        val arr1 = intArrayOf(1, 2, 3)
        var arr2 = intArrayOf()
        assertArrayEquals(intArrayOf(1, 2, 3), arr1 concat arr2)
        assertArrayEquals(intArrayOf(1, 2, 3), arr2 concat arr1)

        arr2 = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 1, 2, 3, 4), arr1 concatX arr2)
    }

    @Test
    fun `concatenation of two arrays vertically`() {
        val arr1 = intArrayOf(1, 2, 3)
        var arr2 = intArrayOf()
        assertArrayEquals(arrayOf(intArrayOf(1, 2, 3)), arr1 concatY arr2)
        assertArrayEquals(arrayOf(intArrayOf(1, 2, 3)), arr2 concatY arr1)

        arr2 = intArrayOf(1, 2, 3, 4)
        assertThrows(DifferentArrayLengthException::class.java) { arr1 concatY arr2 }
        assertThrows(DifferentArrayLengthException::class.java) { arr2 concatY arr1 }

        arr2 = intArrayOf(4, 5, 6)
        var expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        assertArrayEquals(expected, arr1 concatY arr2)
        expected = arrayOf(
            intArrayOf(4, 5, 6),
            intArrayOf(1, 2, 3)
        )
        assertArrayEquals(expected, arr2 concatY arr1)
    }
}
