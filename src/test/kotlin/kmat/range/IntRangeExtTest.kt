package kmat.range

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@Suppress("EmptyRange")
class IntRangeExtTest {

    @Test
    fun `range with steps`() {
        assertRange(0..10..100)
        assertRange(1..10..100)
        assertRange(0..100..10)

        assertEquals(11, (0..10..100).count())
        assertEquals(10, (1..10..100).count())
        assertEquals(1, (0..100..10).count())
    }

    @Test
    fun `range with negative steps`() {
        assertDownRange(100..-10..0)
        assertDownRange(100..-10..1)

        assertEquals(11, (100..-10..0).count())
        assertEquals(10, (100..-10..1).count())
        assertEquals(1, (10..-100..1).count())
    }

    private fun assertRange(range: IntProgression) {
        range.forEachIndexed { index, i ->
            assertTrue(i / 10 == index)
        }
    }

    private fun assertDownRange(range: IntProgression) {
        range.forEachIndexed { index, i ->
            assertTrue(i / 10 == 10 - index)
        }
    }

    @Test
    fun `range to array`() {
        assertArrayEquals((1..10).arr, IntArray(10) { it + 1 })
        assertArrayEquals((10..1).arr, intArrayOf())

        assertArrayEquals((0..10..100).arr, intArrayOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100))
        assertArrayEquals((1..10..100).arr, intArrayOf(1, 11, 21, 31, 41, 51, 61, 71, 81, 91))
        assertArrayEquals((0..100..10).arr, intArrayOf(0))
    }

    @Test
    fun `range with negative steps to array`() {
        assertArrayEquals((1..-10).arr, intArrayOf())
        assertArrayEquals((10..-1).arr, intArrayOf())

        assertArrayEquals((100..-10..0).arr, intArrayOf(100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 0))
        assertArrayEquals((100..-10..1).arr, intArrayOf(100, 90, 80, 70, 60, 50, 40, 30, 20, 10))
    }

    @Test
    fun `transpose of range`() {
        assertArrayEquals((1..10).T, Array<IntArray>(10) { intArrayOf(it + 1) })
        assertArrayEquals((10..1).T, Array<IntArray>(0) { intArrayOf() })

        assertArrayEquals(
            (0..10..100).T, arrayOf(
                intArrayOf(0),
                intArrayOf(10),
                intArrayOf(20),
                intArrayOf(30),
                intArrayOf(40),
                intArrayOf(50),
                intArrayOf(60),
                intArrayOf(70),
                intArrayOf(80),
                intArrayOf(90),
                intArrayOf(100)
            )
        )
        assertArrayEquals(
            (1..10..100).T, arrayOf(
                intArrayOf(1),
                intArrayOf(11),
                intArrayOf(21),
                intArrayOf(31),
                intArrayOf(41),
                intArrayOf(51),
                intArrayOf(61),
                intArrayOf(71),
                intArrayOf(81),
                intArrayOf(91)
            )
        )
        assertArrayEquals((0..100..10).T, arrayOf(intArrayOf(0)))
    }

    @Test
    fun `transpose of range with negative steps`() {
        assertArrayEquals((1..-10).T, Array<IntArray>(0) { intArrayOf() })
        assertArrayEquals((10..-1).T, Array<IntArray>(0) { intArrayOf() })

        assertArrayEquals(
            (100..-10..0).T, arrayOf(
                intArrayOf(100),
                intArrayOf(90),
                intArrayOf(80),
                intArrayOf(70),
                intArrayOf(60),
                intArrayOf(50),
                intArrayOf(40),
                intArrayOf(30),
                intArrayOf(20),
                intArrayOf(10),
                intArrayOf(0)
            )
        )
        assertArrayEquals(
            (100..-10..1).T, arrayOf(
                intArrayOf(100),
                intArrayOf(90),
                intArrayOf(80),
                intArrayOf(70),
                intArrayOf(60),
                intArrayOf(50),
                intArrayOf(40),
                intArrayOf(30),
                intArrayOf(20),
                intArrayOf(10)
            )
        )
    }
}
