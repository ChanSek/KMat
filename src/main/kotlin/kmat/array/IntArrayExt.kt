@file:JvmName("IntArrayExt")

package kmat.array

/**
 * Returns an array containing elements at indices in the specified [indices] range.
 */
operator fun IntArray.get(range: IntRange) = sliceArray(range)

/**
 * Sets the specified value at indices in the specified [indices] range.
 */
operator fun IntArray.set(range: IntRange, value: Int) {
    range.forEach { this[it] = value }
}

operator fun IntArray.plus(value: Int): IntArray {
    val resultArr = IntArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i + value
    }
    return resultArr
}

@Throws(DifferentArrayLengthException::class)
operator fun IntArray.plus(value: IntArray): IntArray {
    if (size != value.size) throw DifferentArrayLengthException("Both operand arrays has different size")
    val resultArr = IntArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i + value[index]
    }
    return resultArr
}

operator fun IntArray.plusAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i + value
    }
}

operator fun IntArray.times(value: Int): IntArray {
    val resultArr = IntArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i * value
    }
    return resultArr
}

@Throws(DifferentArrayLengthException::class)
operator fun IntArray.times(value: Array<IntArray>): Int {
    if (size != value.size) throw DifferentArrayLengthException("Both operand arrays has different size")
    var result = 0
    forEachIndexed { index, i ->
        result += i * value[index][0]
    }
    return result
}

operator fun IntArray.timesAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i * value
    }
}

operator fun IntArray.div(value: Int): IntArray {
    val resultArr = IntArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i / value
    }
    return resultArr
}

operator fun IntArray.divAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i / value
    }
}

fun IntArray.transpose(): Array<IntArray> {
    val result = Array(size) { IntArray(1) }
    forEachIndexed { index, i ->
        result[index][0] = i
    }
    return result
}

val IntArray.T: Array<IntArray>
    get() = transpose()

infix fun IntArray.concat(other: IntArray): IntArray {
    var index = size
    val result = copyOf(index + other.size)
    for (element in other) result[index++] = element
    return result
}

infix fun IntArray.concatX(other: IntArray) = concat(other)

infix fun IntArray.concatY(other: IntArray) = when {
    isEmpty() -> arrayOf(other)
    other.isEmpty() -> arrayOf(this)
    size != other.size -> throw DifferentArrayLengthException("Both operand arrays has different size")
    else -> arrayOf(this, other)
}
