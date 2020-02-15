package kmat.range

import kmat.array.T

operator fun IntRange.rangeTo(end: Int): IntProgression {
    return if (last > 0)
        first..end step last
    else
        IntProgression.fromClosedRange(first, end, last)
}

val IntRange.arr: IntArray
    get() = toArray()

fun IntRange.toArray(): IntArray {
    if (last < first) return IntArray(0)
    val result = IntArray(last - first + 1)
    forEachIndexed { index, i -> result[index] = i }
    return result
}

val IntRange.T: Array<IntArray>
    get() = arr.T

val IntProgression.arr: IntArray
    get() = toArray()

fun IntProgression.toArray(): IntArray {
    if (last < first && step > 0) return IntArray(0)
    val result = IntArray(((last - first) / step) + 1)
    forEachIndexed { index, i -> result[index] = i }
    return result
}

val IntProgression.T: Array<IntArray>
    get() = arr.T
