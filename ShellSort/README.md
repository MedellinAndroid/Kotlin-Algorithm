# Shell Sort

Shell sort, also known as Shell sort or Shell's method, is an in-place comparison sort.
It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort).
The method starts by sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared.
Starting with far apart elements, it can move some out-of-place elements into position faster than a simple nearest neighbor exchange.
Donald Shell published the first version of this sort in 1959.
The running time of Shellsort is heavily dependent on the gap sequence it uses.

Source: [Wikipedia ShellSort](https://en.wikipedia.org/wiki/Shellsort)

Kotlin playground [link](https://pl.kotl.in/Gp9OtkFz8)

## Code

```kotlin
fun MutableList<Int>.shellSort(): MutableList<Int> {
    var sublistCount = count() / 2

    while (sublistCount > 0) {
        var index = 0
        outer@ while (index >= 0 && index < count()) {

            if (index + sublistCount >= count()) break

            if (this[index] > this[index + sublistCount]) {
                swap(index, index + sublistCount)
            }

            if (sublistCount == 1 && index > 0) {
                while (this[index - 1] > this[index] && index - 1 > 0) {
                    swap(index - 1, index)
                    index -= 1
                }
                index++
            } else {
                index++
                continue@outer
            }
        }

        sublistCount /= 2
    }

    return this
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
```