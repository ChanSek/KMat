package kmat.matrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class IntMatrixTest {

    lateinit var matrix: Array<IntArray>

    @BeforeEach
    fun `initialize a matrix`() {
        matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    }

    @Test
    fun `getting a new matrix by adding an integer value to each element of an input matrix`() {
        val resultMatrix = matrix + 10
        val expectedMatrix = arrayOf(
            intArrayOf(11, 12, 13),
            intArrayOf(14, 15, 16),
            intArrayOf(17, 18, 19)
        )
        assertArrayEquals(expectedMatrix, resultMatrix)
        assertNotEquals(expectedMatrix[0][0], matrix[0][0])
        assertEquals(4, matrix[1][0])
    }

    @Test
    fun `mutating a matrix by adding an integer value to each element of it`() {
        matrix += -10
        val expectedMatrix = arrayOf(
            intArrayOf(-9, -8, -7),
            intArrayOf(-6, -5, -4),
            intArrayOf(-3, -2, -1)
        )
        assertArrayEquals(expectedMatrix, matrix)
    }
}
