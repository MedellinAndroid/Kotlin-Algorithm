# Insertion sort

![](https://github.com/MedellinAndroid/Kotlin-Algorithm/blob/master/InsertionSort/InsertionSort_anim.gif)

Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

Source: [Wikipedia page for Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)

Kotlin playground [link](https://pl.kotl.in/8ZMhBw7Wy)

## Code

```kotlin
fun <T : Comparable<T>> insertionSort(items: MutableList<T>): List<T> {
    if (items.isEmpty()) {
        return items
    }
    for (count in 1..items.count() - 1) {
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
```