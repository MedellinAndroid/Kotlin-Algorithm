/**
 * Created by gazollajunior on 09/04/16.
 */
fun main() {
    println("\nOriginal list:")
    val names = mutableListOf("John", "Tim", "Zack", "Daniel", "Adam")
    println(names)
    println("\nOrdered list:")
    val ordered = insertionSort(names)
    println(ordered)
}

fun <T : Comparable<T>> insertionSort(items: MutableList<T>): List<T> {
    if (items.isEmpty()) {
        return items
    }

    for (count in 1..<items.count()) {
        val item = items[count]
        var i = count
        while (i > 0 && item < items[i - 1]) {
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }
    return items
}
