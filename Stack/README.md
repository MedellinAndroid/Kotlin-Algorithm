# Stack

![](https://github.com/gazolla/Kotlin-Algorithm/blob/master/Stack/Lifo_stack.png)

Stack is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element that was not yet removed. The order in which elements come off a stack gives rise to its alternative name, LIFO (for last in, first out). Additionally, a peek operation may give access to the top without modifying the stack.

Source: [Wikipedia page for Stack](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))

Kotlin playground [link](https://pl.kotl.in/TlCkIAG2I)

## Code

```kotlin
class Stack<T : Comparable<T>>(list: MutableList<T>) : Iterator<T> {

    var itCounter: Int = 0

    var items: MutableList<T> = list

    fun isEmpty(): Boolean = this.items.isEmpty()

    fun count(): Int = this.items.count()

    fun push(element: T) {
        val position = this.count()
        this.items.add(position, element)
    }

    override fun toString() = this.items.toString()

    fun pop(): T? {
        if (this.isEmpty()) {
            return null
        } else {
            val item = this.items.count() - 1
            return this.items.removeAt(item)
        }
    }

    fun peek(): T? {
        if (isEmpty()) {
            return null
        } else {
            return this.items[this.items.count() - 1]
        }
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
```
