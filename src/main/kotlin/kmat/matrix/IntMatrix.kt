package kmat.matrix

import kmat.array.div
import kmat.array.plus
import kmat.array.times

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

operator fun Array<IntArray>.times(value: Int): Array<IntArray> {
    val result = this.copyOf()
    forEachIndexed { index, ints ->
        result[index] = ints * value
    }
    return result
}

infix fun Array<IntArray>.multiply(value: Int) = times(value)

infix fun Array<IntArray>.dot(value: Int) = times(value)

operator fun Array<IntArray>.div(value: Int): Array<IntArray> {
    val result = this.copyOf()
    forEachIndexed { index, ints ->
        result[index] = ints / value
    }
    return result
}

fun Array<IntArray>.transpose(): Array<IntArray> {
    if (isEmpty()) return emptyArray()
    val result = Array(this[0].size) { IntArray(size) }
    forEachIndexed { row, ints ->
        ints.forEachIndexed { col, _ ->
            result[col][row] = this[row][col]
        }
    }
    return result
}
