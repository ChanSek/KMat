package kmat.matrix

import kmat.array.DifferentArrayLengthException
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

operator fun Array<IntArray>.times(value: Array<IntArray>): Array<IntArray> {
    if (this[0].size != value.size) throw DifferentArrayLengthException("Both operand arrays has different size")
    val result: Array<IntArray> = Array(size) { IntArray(value[0].size) }
    for (i in 0 until size) {
        for (j in 0 until value[0].size) {
            for (k in 0 until this[0].size) {
                result[i][j] += this[i][k] * value[k][j]
            }
        }
    }
    return result
}

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
