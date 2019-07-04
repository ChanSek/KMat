@file:Suppress("EmptyRange")

package kmat.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException

class IArrayAccessTest {

    private lateinit var arr: IArray

    @BeforeEach
    fun setup() {
        arr = iArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    @Test
    fun `range access inclusively`() {
        val subArray = arr[3..7]
        assertEquals(iArrayOf(4, 5, 6, 7, 8), subArray)
    }

    @Test
    fun `range access inclusively failure`() {
        val subArray = arr[2..5]
        val expectedArray = iArrayOf(3, 4, 5)
        val equals = subArray == expectedArray
        assertNotEquals(true, equals)
    }

    @Test
    fun `range access exclusively`() {
        val subArray = arr[3 until 7]
        assertEquals(iArrayOf(4, 5, 6, 7), subArray)
    }

    @Test
    fun `out of range access should throw exception`() {
        assertThrows(IndexOutOfBoundsException::class.java) {
            arr[3..20]
        }
    }

    @Test
    fun `invalid range access should return empty array`() {
        assertEquals(iArrayOf(), arr[3..1])
    }
}
