package kmat.math

fun IntArray.sin(): DoubleArray {
    val result = DoubleArray(size)
    forEachIndexed { index, i ->
        result[index] = kotlin.math.sin(i.toDouble())
    }
    return result
}

// TODO : This will fail if the matrix is empty. Need to fix this.
fun Array<IntArray>.sin(): Array<DoubleArray> {
    val result = Array(size) {
        DoubleArray(this[0].size)
    }
    forEachIndexed { index, ints ->
        result[index] = ints.sin()
    }
    return result
}
