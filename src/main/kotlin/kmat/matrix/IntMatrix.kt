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

fun Array<IntArray>.transpose(): Array<IntArray> {
    if (isEmpty()) return emptyArray()
    val result = Array(this[0].size) { IntArray(size) }
    forEachIndexed { row, ints ->
        ints.forEachIndexed { col, i ->
            result[col][row] = this[row][col]
        }
    }
    return result
}
