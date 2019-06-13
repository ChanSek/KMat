package kmat.matrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OnesMatrixTest {

    @Test
    fun `should create an empty vector`() {
        val vector = ones(0, 0)
        val expectedVector = arrayOf<IntArray>()
        assertArrayEquals(expectedVector, vector)

        val vector2 = ones(0, -2)
        assertArrayEquals(expectedVector, vector2)
    }

    @Test
    fun `should create an empty column vector`() {
        val vector = ones(5, 0)
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
        val vector = ones(5, 1)
        val expectedVector = arrayOf(
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
        assertArrayEquals(expectedVector, vector)
    }

    @Test
    fun `should throw exception for invalid vector size`() {
        assertThrows<NegativeArraySizeException> { ones(-1, -2) }
        assertThrows<NegativeArraySizeException> { ones(10, -2) }
        assertThrows<NegativeArraySizeException> { ones(-10, 0) }
    }

    @Test
    fun `should create a row vector`() {
        val vector = ones(1, 5)
        val expectedVector = arrayOf(IntArray(5) { 1 })
        assertArrayEquals(expectedVector, vector)
    }

    @Test
    fun `should create a matrix with ones filled`() {
        val matrix = ones(3, 3)
        val expectedMatrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertArrayEquals(expectedMatrix, matrix)
    }
}
