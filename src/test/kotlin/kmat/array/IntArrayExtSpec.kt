package kmat.array

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

import org.junit.jupiter.api.Assertions.assertArrayEquals

object IntArrayExtSpec : Spek({

    given("An integer array") {
        val arr = IntArray(10) { it }
        it("should return a sub array with elements from 2nd to 7th index") {
            val subArrayInclusive = arr[2..7]
            val expectedSubArray = intArrayOf(2, 3, 4, 5, 6, 7)
            assertArrayEquals(expectedSubArray, subArrayInclusive)
        }
//        on("range access inclusively") {
//            val subArrayInclusive = arr[2..7]
//            it("should return a sub array with elements from 2nd to 7th index") {
//                val expectedSubArray = intArrayOf(2, 3, 4, 5, 6, 7)
//                assertArrayEquals(expectedSubArray, subArrayInclusive)
//            }
//        }
    }
})
