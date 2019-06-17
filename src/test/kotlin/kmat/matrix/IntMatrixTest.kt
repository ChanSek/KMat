package kmat.matrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class IntMatrixTest {

    private lateinit var matrix: Array<IntArray>

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

    @Test
    fun `multiplying an integer value to each element of a matrix`() {
        val resultMatrix = matrix * 10
        val expectedMatrix = arrayOf(
            intArrayOf(10, 20, 30),
            intArrayOf(40, 50, 60),
            intArrayOf(70, 80, 90)
        )
        assertArrayEquals(expectedMatrix, resultMatrix)

        val secondResult = matrix multiply 20
        val secondExpectedMatrix = arrayOf(
            intArrayOf(20, 40, 60),
            intArrayOf(80, 100, 120),
            intArrayOf(140, 160, 180)
        )
        assertArrayEquals(secondExpectedMatrix, secondResult)

        val thirdResult = matrix dot 20
        assertArrayEquals(secondExpectedMatrix, thirdResult)

        matrix *= 10
        assertArrayEquals(expectedMatrix, matrix)
    }

    @Test
    fun `dividing an integer value to each element of a matrix`() {
        val resultMatrix = matrix / 2
        val expectedMatrix = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(2, 2, 3),
            intArrayOf(3, 4, 4)
        )
        assertArrayEquals(expectedMatrix, resultMatrix)

        matrix /= 2
        assertArrayEquals(expectedMatrix, matrix)
    }

    @Test
    fun `transpose of a matrix`() {
        val resultMatrix = matrix.transpose()
        val expectedMatrix = arrayOf(
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(3, 6, 9)
        )
        assertArrayEquals(expectedMatrix, resultMatrix)

        val anotherMatrix = arrayOf(
            intArrayOf(2, 5),
            intArrayOf(3, 51),
            intArrayOf(2, 25),
            intArrayOf(212, 590)
        )
        val anotherExpectedMatrix = arrayOf(
            intArrayOf(2, 3, 2, 212),
            intArrayOf(5, 51, 25, 590)
        )
        assertArrayEquals(anotherExpectedMatrix, anotherMatrix.transpose())
    }

    @Test
    fun `transpose of an empty matrix should return an empty matrix`() {
        matrix = arrayOf()
        val resultMatrix = matrix.transpose()
        val expectedMatrix = emptyArray<IntArray>()
        assertArrayEquals(expectedMatrix, resultMatrix)
    }
}
