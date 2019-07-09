package kmat.range

operator fun IntRange.rangeTo(end: Int): IntProgression {
    return if (last > 0)
        first..end step last
    else
        IntProgression.fromClosedRange(first, end, last)
}
