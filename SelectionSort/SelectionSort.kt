/**
 * Created by gazollajunior on 09/04/16.
 */
fun main() {
    println("\nOriginal list:")
    val names = mutableListOf("John", "Tim", "Zack", "Daniel", "Adam")
    println(names)
    println("\nOrdered list:")
    val ordered = selectionSort(names)
    println(ordered)
}

fun <T : Comparable<T>> selectionSort(items: MutableList<T>): MutableList<T> {
    if (items.isEmpty()) {
        return items
    }
    for (idx in 0..items.count()) {
        val array = items.subList(0, items.count() - idx)
        val minItem = array.minOrNull()
        val indexOfMinItem = array.indexOf(minItem)

        if (minItem != null) {
            items.removeAt(indexOfMinItem)
            items.add(minItem)
        }
    }
    return items
}
