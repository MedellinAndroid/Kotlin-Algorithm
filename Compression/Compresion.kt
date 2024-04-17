package compression

/**
 * Calculation of Run Length Encoding using Tail Recursion
 * Created by Andy on 05/05/2016.
 */

tailrec fun runLengthEncoding(text: String, prev: String = ""): String {
    if (text.isEmpty()) {
        return prev
    }
    val initialChar = text.get(0)
    val count = text.takeWhile { it == initialChar }.count()
    return runLengthEncoding(text.substring(count), prev + "$count$initialChar")
}