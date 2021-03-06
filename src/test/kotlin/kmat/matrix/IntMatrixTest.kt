package kmat.matrix

import kmat.array.DifferentArrayLengthException
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
    fun `multiplying two matrices`() {
        val matrix2 = arrayOf(
            intArrayOf(10, 20, 30),
            intArrayOf(40, 50, 60),
            intArrayOf(70, 80, 90)
        )
        val expectedMatrix = arrayOf(
            intArrayOf(300, 360, 420),
            intArrayOf(660, 810, 960),
            intArrayOf(1020, 1260, 1500)
        )
        assertArrayEquals(expectedMatrix, matrix * matrix2)
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

        val transposedMatrix = matrix.T
        assertArrayEquals(transposedMatrix, resultMatrix)
    }

    @Test
    fun `transpose of an empty matrix should return an empty matrix`() {
        matrix = arrayOf()
        val resultMatrix = matrix.transpose()
        val expectedMatrix = emptyArray<IntArray>()
        assertArrayEquals(expectedMatrix, resultMatrix)
    }

    @Test
    fun `concatenation of two matrices horizontally`() {
        var matrix2: Array<IntArray> = arrayOf()
        assertArrayEquals(matrix, matrix concat matrix2)
        assertArrayEquals(matrix, matrix2 concat matrix)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8)
        )
        assertThrows(DifferentArrayLengthException::class.java) { matrix concat matrix2 }
        assertThrows(DifferentArrayLengthException::class.java) { matrix2 concat matrix }

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3, 10),
            intArrayOf(4, 5, 6, 20),
            intArrayOf(7, 8, 9, 30)
        )
        var expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3, 1, 2, 3, 10),
            intArrayOf(4, 5, 6, 4, 5, 6, 20),
            intArrayOf(7, 8, 9, 7, 8, 9, 30)
        )
        assertArrayEquals(expectedMatrix, matrix concat matrix2)

        expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3, 10, 1, 2, 3),
            intArrayOf(4, 5, 6, 20, 4, 5, 6),
            intArrayOf(7, 8, 9, 30, 7, 8, 9)
        )
        assertArrayEquals(expectedMatrix, matrix2 concatX matrix)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3, 1, 2, 3),
            intArrayOf(4, 5, 6, 4, 5, 6),
            intArrayOf(7, 8, 9, 7, 8, 9)
        )
        assertArrayEquals(expectedMatrix, matrix concat matrix2)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(10, 11, 12)
        )
        assertThrows(DifferentArrayLengthException::class.java) { matrix concat matrix2 }
        assertThrows(DifferentArrayLengthException::class.java) { matrix2 concatX matrix }
    }

    @Test
    fun `concatenation of two matrices vertically`() {
        var matrix2: Array<IntArray> = arrayOf()
        assertArrayEquals(matrix, matrix concatY matrix2)
        assertArrayEquals(matrix, matrix2 concatY matrix)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        var expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(expectedMatrix, matrix concatY matrix2)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        assertArrayEquals(expectedMatrix, matrix concatY matrix2)

        expectedMatrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(expectedMatrix, matrix2 concatY matrix)

        matrix2 = arrayOf(
            intArrayOf(1, 2, 3, 7),
            intArrayOf(4, 5, 6, 7)
        )
        assertThrows(DifferentArrayLengthException::class.java) { matrix concatY matrix2 }
        assertThrows(DifferentArrayLengthException::class.java) { matrix2 concatY matrix }
    }
}
