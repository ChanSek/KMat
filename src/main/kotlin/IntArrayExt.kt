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
