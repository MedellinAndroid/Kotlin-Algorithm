/**
 * Created by gazollajunior on 03/04/16.
 */

import java.util.Collections
import java.util.Random

fun main() {
    println("\nOrdered list:")
    val ordered = listOf("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    println("\nShuffled list:")
    val shuffled = shuffle(ordered as MutableList<String>)
    print(shuffled)

    println("\n\nOrdered list:")
    val orderedB = listOf(1, 2, 3, 4, 5)
    println(orderedB)
    println("\nShuffled list:")
    print(orderedB.shuffle())
}

fun <T : Comparable<T>> shuffle(items: MutableList<T>): List<T> {
    val rg = Random()
    for (i in 0..<items.size) {
        val randomPosition = rg.nextInt(items.size)
        val tmp: T = items[i]
        items[i] = items[randomPosition]
        items[randomPosition] = tmp
    }
    return items
}

/* extension version */
fun <T> Iterable<T>.shuffle(): List<T> {
    val list = this.toMutableList().apply { }
    Collections.shuffle(list)
    return list
}
