package kmat.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IndexOutOfBoundsException

class IArrayUpdateTest {

    @Test
    fun `out of bound index set should increase the array size`() {
        val arr = IArray(10) { it }
        arr[10] = 20
        var expectedArr = iArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20)
        assertEquals(expectedArr, arr)

        arr[2] = 10
        expectedArr = iArrayOf(0, 1, 10, 3, 4, 5, 6, 7, 8, 9, 20)
        assertEquals(expectedArr, arr)

        assertThrows<IndexOutOfBoundsException> { arr[-1] = 10 }

        arr[15] = 30
        expectedArr = iArrayOf(0, 1, 10, 3, 4, 5, 6, 7, 8, 9, 20, 0, 0, 0, 0, 30)
        assertEquals(expectedArr, arr)
    }

    @Test
    fun `range set inclusively`() {
        val arr = IArray(10) { it }
        arr[3..7] = 20
        assertEquals(iArrayOf(0, 1, 2, 20, 20, 20, 20, 20, 8, 9), arr)
    }

    @Test
    fun `range set exclusively`() {
        val arr = IArray(10) { it }
        arr[3 until 7] = 20
        assertEquals(iArrayOf(0, 1, 2, 20, 20, 20, 20, 7, 8, 9), arr)
    }

    @Test
    fun `out of range set should have a bigger array`() {
        var arr = IArray(10) { it }
        arr[3 until 20] = 30
        var expectedArr = iArrayOf(0, 1, 2, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30)
        assertEquals(expectedArr, arr)

        arr[4..10] = 20
        expectedArr = iArrayOf(0, 1, 2, 30, 20, 20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30)
        assertEquals(expectedArr, arr)

        arr = IArray(10) { it }
        arr[4..10] = 20
        expectedArr = iArrayOf(0, 1, 2, 3, 20, 20, 20, 20, 20, 20, 20)
        assertEquals(expectedArr, arr)

        arr = IArray(10) { it }
        arr[4..9] = 20
        expectedArr = iArrayOf(0, 1, 2, 3, 20, 20, 20, 20, 20, 20)
        assertEquals(expectedArr, arr)

        assertThrows<IndexOutOfBoundsException> {
            arr[-1..10] = 100
        }
    }

    @Test
    fun `invalid range set should not do anything`() {
        val arr = IArray(10) { it * it }
        arr[7 until 3] = 34
        assertEquals(IArray(10) { it * it }, arr)
    }
}
