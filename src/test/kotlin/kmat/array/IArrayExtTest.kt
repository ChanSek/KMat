package kmat.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IArrayExtTest {

    @Test
    fun `adding a value to each element of array`() {
        val arr = iArrayOf(2, 5, 7)
        val resultArr = arr + 10
        assertEquals(resultArr, iArrayOf(12, 15, 17))

        arr += 10
        assertEquals(arr, iArrayOf(12, 15, 17))
    }

    @Test
    fun `adding two integer arrays`() {
        val arr1 = iArrayOf(2, 5, 7)
        val arr2 = iArrayOf(10, 20, 30)
        assertEquals(iArrayOf(12, 25, 37), arr1 + arr2)

        val arr3 = iArrayOf()
        assertThrows(DifferentArrayLengthException::class.java) {
            arr1 + arr3
        }

        val arr4 = iArrayOf(1, 2, 3)
        assertEquals(iArrayOf(13, 27, 40), arr1 + arr2 + arr4)
    }

    @Test
    fun `multiplying a value to each element of array`() {
        val arr = iArrayOf(2, 5, 7)
        val resultArr = arr * 10
        assertEquals(resultArr, iArrayOf(20, 50, 70))

        arr *= 10
        assertEquals(arr, iArrayOf(20, 50, 70))
    }

    @Test
    fun `multiplying a matrix with an array`() {
        // TODO - Need to implement this
//        val arr = iArrayOf(2, 5, 7)
//        val matrix = arrayOf(
//            iArrayOf(1),
//            iArrayOf(2),
//            iArrayOf(3)
//        )
//        val result = arr * matrix
//        assertEquals(33, result)
//
//        val arr2 = iArrayOf(2, 5, 7, 6)
//        assertThrows(DifferentArrayLengthException::class.java) {
//            arr2 * matrix
//        }
//
//        val matrix2: Array<IntArray> = arrayOf()
//        assertThrows(DifferentArrayLengthException::class.java) {
//            arr2 * matrix2
//        }
    }

    @Test
    fun `dividing a value to each element of array`() {
        val arr = iArrayOf(2, 5, 7)
        val resultArr = arr / 2
        assertEquals(resultArr, iArrayOf(1, 2, 3))

        arr /= 2
        assertEquals(arr, iArrayOf(1, 2, 3))
    }

    @Test
    fun `transpose of a row vector`() {
        val arr = iArrayOf(2, 5, 7)
        val result = arr.transpose()
        assertArrayEquals(result, arrayOf(
            iArrayOf(2),
            iArrayOf(5),
            iArrayOf(7)
        ))

        val arr2 = iArrayOf(10, 20, 30)
        val result2 = arr2.T
        assertArrayEquals(result2, arrayOf(
            iArrayOf(10),
            iArrayOf(20),
            iArrayOf(30)
        ))
    }

    @Test
    fun `transpose of an empty row vector should return empty`() {
        val arr = iArrayOf()
        val result = arr.transpose()
        assertArrayEquals(result, arrayOf<IArray>())
    }

    @Test
    fun `concatenation of two arrays horizontally`() {
        val arr1 = iArrayOf(1, 2, 3)
        var arr2 = iArrayOf()
        assertEquals(iArrayOf(1, 2, 3), arr1 concat arr2)
        assertEquals(iArrayOf(1, 2, 3), arr2 concat arr1)

        arr2 = iArrayOf(1, 2, 3, 4)
        assertEquals(iArrayOf(1, 2, 3, 1, 2, 3, 4), arr1 concatX arr2)
    }

    @Test
    fun `concatenation of two arrays vertically`() {
        val arr1 = iArrayOf(1, 2, 3)
        var arr2 = iArrayOf()
        assertArrayEquals(arrayOf(iArrayOf(1, 2, 3)), arr1 concatY arr2)
        assertArrayEquals(arrayOf(iArrayOf(1, 2, 3)), arr2 concatY arr1)

        arr2 = iArrayOf(1, 2, 3, 4)
        assertThrows(DifferentArrayLengthException::class.java) { arr1 concatY arr2 }
        assertThrows(DifferentArrayLengthException::class.java) { arr2 concatY arr1 }

        arr2 = iArrayOf(4, 5, 6)
        var expected = arrayOf(
            iArrayOf(1, 2, 3),
            iArrayOf(4, 5, 6)
        )
        assertArrayEquals(expected, arr1 concatY arr2)
        expected = arrayOf(
            iArrayOf(4, 5, 6),
            iArrayOf(1, 2, 3)
        )
        assertArrayEquals(expected, arr2 concatY arr1)
    }
}
