import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException
import java.util.*

class IntArrayExtTest {

    @Test
    fun `range access inclusively`() {
        val arr = IntArray(10) { it }
        val subArray = arr[3..7]
        assertArrayEquals(intArrayOf(3, 4, 5, 6, 7), subArray)
    }

    @Test
    fun `range access inclusively failure`() {
        val arr = intArrayOf(2, 5, 7, 8, 9, 10, 23)
        val subArray = arr[2..5]
        val expectedArray = intArrayOf(7, 8, 9)
        val equals = Arrays.equals(subArray, expectedArray)
        assertNotEquals(true, equals)
    }

    @Test
    fun `range access exclusively`() {
        val arr = IntArray(10) { it * it }
        val subArray = arr[3 until 7]
        assertArrayEquals(intArrayOf(9, 16, 25, 36), subArray)
    }

    @Test
    fun `out of range access should throw exception`() {
        val arr = IntArray(10) { it * it }
        assertThrows(IndexOutOfBoundsException::class.java) {
            arr[3..20]
        }
    }
}
