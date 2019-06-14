package kmat.math

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MathTest {

    @Test
    fun `sin operation to each element of an array`() {
        val arr = intArrayOf(3, 6, 20)
        val sinArr = arr.sin()
        assertArrayEquals(doubleArrayOf(0.1411200080598672, -0.27941549819892586, 0.9129452507276277), sinArr)
    }

    @Test
    fun `sin operation of an empty array should return an empty array`() {
        val arr = intArrayOf()
        val sinArr = arr.sin()
        assertArrayEquals(doubleArrayOf(), sinArr)
    }

    @Test
    fun `sin operation to each element of a matrix`() {
        val matrix = arrayOf(
            intArrayOf(3, 6, 20),
            intArrayOf(5, 9, 10)
        )
        val sinMatrix = matrix.sin()
        assertArrayEquals(arrayOf(
            doubleArrayOf(0.1411200080598672, -0.27941549819892586, 0.9129452507276277),
            doubleArrayOf(-0.9589242746631385, 0.4121184852417566, -0.5440211108893698)
        ), sinMatrix)
    }

    @Test
    fun `sin operation of an empty matrix should return an empty matrix`() {
        val matrix = arrayOf(
            intArrayOf(),
            intArrayOf()
        )
        val sinMatrix = matrix.sin()
        assertArrayEquals(arrayOf(doubleArrayOf(), doubleArrayOf()), sinMatrix)
    }
}
