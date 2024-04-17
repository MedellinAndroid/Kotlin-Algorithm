/**
 * Created by gazollajunior on 05/04/16.
 */
fun main() {
    val initialValue = mutableListOf(10)
    val queue = Queue(initialValue)

    println(queue)
    queue.enqueue(22)
    println(queue)
    queue.enqueue(55)
    println(queue)
    queue.enqueue(77)
    println(queue)
    queue.dequeue()
    println(queue)
    queue.dequeue()
    println(queue)
    queue.dequeue()
    println(queue)

    // Iterating over queue
    for (item in queue) println("Item in queue : $item")
}

class Queue<T>(list: MutableList<T>) : Iterator<T> {

    var itCounter: Int = 0

    var items: MutableList<T> = list

    fun isEmpty(): Boolean = this.items.isEmpty()

    fun count(): Int = this.items.count()

    override fun toString() = this.items.toString()

    fun enqueue(element: T) {
        this.items.add(element)
    }

    fun dequeue(): T? {
        return if (this.isEmpty()) {
            null
        } else {
            this.items.removeAt(0)
        }
    }

    fun peek(): T? {
        return this.items[0]
    }

    override fun hasNext(): Boolean {
        val hasNext = itCounter < count()

        // As soon as condition fails, reset the counter
        if (!hasNext) itCounter = 0

        return hasNext
    }

    override fun next(): T {
        if (hasNext()) {
            val topPos: Int = (count() - 1) - itCounter
            itCounter++
            return this.items[topPos]
        } else {
            throw NoSuchElementException("No such element")
        }
    }
}
