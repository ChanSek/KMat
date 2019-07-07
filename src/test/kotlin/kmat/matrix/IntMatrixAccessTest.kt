package kmat.matrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException
import kmat.array.*

@Suppress("EmptyRange")
class IntMatrixAccessTest {

    private lateinit var matrix: Array<IntArray>

    @BeforeEach
    fun setup() {
        matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    }

    @Test
    fun `access a particular item`() {
        assertEquals(5, matrix[1][1])
        assertEquals(8, matrix[2, 1])

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[3][1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[3, 1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2][12] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2, 12] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1][12] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1, 12] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1][-2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1, -2] }
    }

    @Test
    fun `access a particular row`() {
        var result = matrix[2, 0..2]
        var expected = intArrayOf(7, 8, 9)
        assertArrayEquals(expected, result)

        result = matrix[2][0..2]
        expected = intArrayOf(7, 8, 9)
        assertArrayEquals(expected, result)

        result = matrix[1, 0 until 2]
        expected = intArrayOf(4, 5)
        assertArrayEquals(expected, result)

        result = matrix[0][0 until 2]
        expected = intArrayOf(1, 2)
        assertArrayEquals(expected, result)

        result = matrix[2, 0..0]
        expected = intArrayOf(7)
        assertArrayEquals(expected, result)

        result = matrix[1, 1 until 2]
        expected = intArrayOf(5)
        assertArrayEquals(expected, result)

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1, 0..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1][0..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2, 0..5] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2][0..5] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1, -1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1][-1..2] }

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1, -1 until 2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1][-1 until 2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1, 2 until 3] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[5][1 until 2] }
    }

    @Test
    fun `access a particular column`() {
        var result = matrix[1..2, 1]
        var expected = arrayOf(
            intArrayOf(5),
            intArrayOf(8)
        )
        assertArrayEquals(expected, result)

        result = matrix[0 until 3, 0]
        expected = arrayOf(
            intArrayOf(1),
            intArrayOf(4),
            intArrayOf(7)
        )
        assertArrayEquals(expected, result)

        result = matrix[1 until 3, 2]
        expected = arrayOf(
            intArrayOf(6),
            intArrayOf(9)
        )
        assertArrayEquals(expected, result)

        result = matrix[0..0, 2]
        expected = arrayOf(intArrayOf(3))
        assertArrayEquals(expected, result)

        result = matrix[1 until 2, 2]
        expected = arrayOf(intArrayOf(6))
        assertArrayEquals(expected, result)

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..2, -1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..2][-1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..5, 2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..5][2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1..2, 1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1..2][1] }

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1 until 2, 1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1 until 2][1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2 until 3, -1] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1 until 2][5] }
    }

    @Test
    fun `access a sub-matrix`() {
        var result = matrix[0..1, 1..2]
        var expected = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(5, 6)
        )
        assertArrayEquals(expected, result)

        result = matrix[0 until 3, 1..2]
        expected = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(5, 6),
            intArrayOf(8, 9)
        )
        assertArrayEquals(expected, result)

        result = matrix[0..2, 0 until 2]
        expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 5),
            intArrayOf(7, 8)
        )
        assertArrayEquals(expected, result)

        result = matrix[0..0, 0 until 2]
        expected = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(expected, result)

        result = matrix[0..0, 1 until 2]
        expected = arrayOf(intArrayOf(2))
        assertArrayEquals(expected, result)

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..2, -1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..2][-1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..5, 1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[0..5][1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1..2, 1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1..2][1..2] }

        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1 until 2, 1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1 until 2][1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[2 until 3, -1..2] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1 until 2][5..10] }
    }

    @Test
    fun `invalid range access should return empty array`() {
        var result = matrix[2..0, 1]
        val expected: Array<IntArray> = arrayOf()
        assertArrayEquals(expected, result)

        val result1 = matrix[1, 2..1]
        assertArrayEquals(intArrayOf(), result1)

        result = matrix[2..0, 2..1]
        assertArrayEquals(expected, result)

        result = matrix[2..0, 1..2]
        assertArrayEquals(expected, result)

        result = matrix[0..2, 2..1]
        assertArrayEquals(expected, result)

        result = matrix[0..2, 1 until 1]
        assertArrayEquals(expected, result)

        result = matrix[0 until 0, 1 until 2]
        assertArrayEquals(expected, result)

        assertArrayEquals(expected, matrix[5..0, 0..1])
        assertArrayEquals(expected, matrix[5..0, 1..0])
        assertArrayEquals(expected, matrix[0..1, 3..0])
        assertArrayEquals(expected, matrix[1..0, 3..0])
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[-1, 1..0] }
        assertThrows(IndexOutOfBoundsException::class.java) { matrix[1..0, -2] }
    }
}
