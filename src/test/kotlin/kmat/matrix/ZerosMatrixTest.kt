package kmat.matrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.assertThrows

class ZerosMatrixTest {

    @Test
    fun `should create an empty vector`() {
        val vector = zeros(0, 0)
        val expectedVector = arrayOf<IntArray>()
        assertArrayEquals(expectedVector, vector)

        val vector2 = zeros(0, -2)
        assertArrayEquals(expectedVector, vector2)
    }

    @Test
    fun `should create an empty column vector`() {
        val vector = zeros(5, 0)
        val expectedVector = arrayOf(
            intArrayOf(),
            intArrayOf(),
            intArrayOf(),
            intArrayOf(),
            intArrayOf()
        )
        assertArrayEquals(expectedVector, vector)
    }

    @Test
    fun `should create a column vector`() {
        val vector = zeros(5, 1)
        val expectedVector = arrayOf(
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0)
        )
        assertArrayEquals(expectedVector, vector)
    }

    @Test
    fun `should throw exception for invalid vector size`() {
        assertThrows<NegativeArraySizeException> { zeros(-1, -2) }
        assertThrows<NegativeArraySizeException> { zeros(10, -2) }
        assertThrows<NegativeArraySizeException> { zeros(-10, 0) }
    }

    @Test
    fun `should create a row vector`() {
        val vector = zeros(1, 5)
        val expectedVector = arrayOf(IntArray(5))
        assertArrayEquals(expectedVector, vector)
    }

    @Test
    fun `should create a matrix with zeroes filled`() {
        val matrix = zeros(3, 3)
        val expectedMatrix = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertArrayEquals(expectedMatrix, matrix)
    }
}
