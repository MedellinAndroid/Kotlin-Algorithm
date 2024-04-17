# Quick sort

<p align="center">
  <img width="400" src="https://github.com/MedellinAndroid/Kotlin-Algorithm/blob/master/QuickSort/QuickSort_anim.gif">
</p>

QuickSort is an efficient sorting algorithm, serving as a systematic method for placing the elements of an array in order. Developed by Tony Hoare in 1959, with his work published in 1961, it is still a commonly used algorithm for sorting. When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort.

Source: [Wikipedia page for Quick sort](https://en.wikipedia.org/wiki/Quicksort)

Kotlin playground [link](https://pl.kotl.in/FK5MseqOK)

Here's an implementation in kotlin that should be easy to understand:

```kotlin
fun <T : Comparable<T>> quickSort(items: List<T>): List<T> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quickSort(less) + equal + quicksort(greater)
}
```