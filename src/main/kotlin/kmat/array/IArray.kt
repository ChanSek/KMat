package kmat.array

class IArray(internal var size: Int) {

    internal var arr = IntArray(size)

    constructor(size: Int, init: (Int) -> Int) : this(size) {
        arr = IntArray(size, init)
    }

    constructor(sourceArray: IntArray) : this(sourceArray.size) {
        arr = sourceArray.copyOf()
    }

    fun isEmpty() = size == 0

    operator fun get(index: Int) = arr[index]

    operator fun get(range: IntRange) = IArray(arr[range])

    operator fun set(index: Int, value: Int) {
        if (index >= size) {
            val newArr = IntArray(index + 1)
            System.arraycopy(arr, 0, newArr, 0, size)
            size = index + 1
            arr = newArr
        }
        arr[index] = value
    }

    operator fun set(range: IntRange, value: Int) {
        if (range.last >= size) {
            val newSize = range.last + 1
            val newArr = IntArray(newSize)
            System.arraycopy(arr, 0, newArr, 0, size)
            size = newSize
            arr = newArr
        }
        range.forEach { arr[it] = value }
    }

    operator fun iterator() = arr.iterator()

    // TODO - Need to identify why Kotlin's stdlib classes like IntArray doesn't has equals() method
    //  Instead of this why Kotlin prefer to use contentEquals
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return when(other) {
            is IArray -> arr.contentEquals(other.arr)
            is IntArray -> arr.contentEquals(other)
            else -> false
        }
    }

    override fun hashCode() = arr.hashCode()
}

fun iArrayOf(vararg args: Int) = IArray(args.size) { args[it] }
