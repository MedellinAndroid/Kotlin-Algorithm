/**
 * Created by gazollajunior on 05/04/16.
 */

fun <T : Comparable<T>> linearSearch(list: List<T>, key: T): Int? {
    for ((index, value) in list.withIndex()) {
        if (value == key) return index
    }
    return null
}

fun main() {
    println("\nOrdered list:")
    val ordered = listOf<String>("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    val name = "John"
    val position = linearSearch(ordered, name)
    println("\n${name} is in the position ${position} in the ordered List.")
}
