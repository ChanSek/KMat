@file:JvmName("IArrayExt")

package kmat.array

/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself
 * and performs the desired action on the element.
 */
inline fun IArray.forEachIndexed(action: (index: Int, Int) -> Unit) {
    var index = 0
    for (item in this) action(index++, item)
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 */
fun IArray.copyOf(newSize: Int): IArray {
    return IArray(this.arr.copyOf(newSize))
}

/**
 * Sets the specified value at indices in the specified [indices] range.
 */
operator fun IArray.set(range: IntRange, value: Int) {
    range.forEach { this[it] = value }
}

operator fun IArray.plus(value: Int): IArray {
    val resultArr = IArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i + value
    }
    return resultArr
}

@Throws(DifferentArrayLengthException::class)
operator fun IArray.plus(value: IArray): IArray {
    if (size != value.size) throw DifferentArrayLengthException("Both operand arrays has different size")
    val resultArr = IArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i + value[index]
    }
    return resultArr
}

operator fun IArray.plusAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i + value
    }
}

operator fun IArray.times(value: Int): IArray {
    val resultArr = IArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i * value
    }
    return resultArr
}

@Throws(DifferentArrayLengthException::class)
operator fun IArray.times(value: Array<IArray>): Int {
    if (size != value.size) throw DifferentArrayLengthException("Both operand arrays has different size")
    var result = 0
    forEachIndexed { index, i ->
        result += i * value[index][0]
    }
    return result
}

operator fun IArray.timesAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i * value
    }
}

operator fun IArray.div(value: Int): IArray {
    val resultArr = IArray(size)
    forEachIndexed { index, i ->
        resultArr[index] = i / value
    }
    return resultArr
}

operator fun IArray.divAssign(value: Int) {
    forEachIndexed { index, i ->
        this[index] = i / value
    }
}

fun IArray.transpose(): Array<IArray> {
    val result = Array(size) { IArray(1) }
    forEachIndexed { index, i ->
        result[index][0] = i
    }
    return result
}

val IArray.T: Array<IArray>
    get() = transpose()

infix fun IArray.concat(other: IArray): IArray {
    var index = size
    val result = copyOf(index + other.size)
    for (element in other) result[index++] = element
    return result
}

infix fun IArray.concatX(other: IArray) = concat(other)

infix fun IArray.concatY(other: IArray) = when {
    isEmpty() -> arrayOf(other)
    other.isEmpty() -> arrayOf(this)
    size != other.size -> throw DifferentArrayLengthException("Both operand arrays has different size")
    else -> arrayOf(this, other)
}
