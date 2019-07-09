package kmat.range

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

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
}
