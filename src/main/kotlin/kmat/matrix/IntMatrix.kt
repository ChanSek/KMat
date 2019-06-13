package kmat.matrix

import kmat.array.plus

fun zeros(row: Int, col: Int) = Array(row) {
    IntArray(col)
}

fun ones(row: Int, col: Int) = Array(row) {
    IntArray(col) { 1 }
}

operator fun Array<IntArray>.plus(value: Int): Array<IntArray> {
    val result = this.copyOf()
    forEachIndexed { index, ints ->
        result[index] = ints + value
    }
    return result
}
