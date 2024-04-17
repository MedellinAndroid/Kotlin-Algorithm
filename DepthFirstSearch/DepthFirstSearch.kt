import java.util.Stack

fun main() {
    val adjacencyList = AdjacencyList<String>()

    val s = adjacencyList.createVertex("S")
    val a = adjacencyList.createVertex("A")
    val b = adjacencyList.createVertex("B")
    val c = adjacencyList.createVertex("C")
    val d = adjacencyList.createVertex("D")
    val f = adjacencyList.createVertex("F")
    val g = adjacencyList.createVertex("G")
    val e = adjacencyList.createVertex("E")

    adjacencyList.add(Undirected(), s, a)
    adjacencyList.add(Undirected(), a, b)
    adjacencyList.add(Undirected(), a, d)
    adjacencyList.add(Undirected(), a, c)
    adjacencyList.add(Undirected(), b, d)
    adjacencyList.add(Undirected(), d, g)
    adjacencyList.add(Undirected(), d, f)
    adjacencyList.add(Undirected(), f, e)

    print(adjacencyList)
    print(depthFirstSearch(s, e, adjacencyList))
}

fun depthFirstSearch(start: Vertex<String>, end: Vertex<String>, graph: AdjacencyList<String>): Stack<Vertex<String>> {
    val visited: MutableSet<Vertex<String>> = mutableSetOf()
    val stack = Stack<Vertex<String>>()

    stack.push(start)
    visited.add(start)

    var vertex = stack.peek()

    loop@ while (vertex != null && vertex != end) {

        val neighbors = graph.edges(vertex)
        if (!neighbors.isNullOrEmpty()) {

            for (edge in neighbors) {
                if (!visited.contains(edge.destination)) {
                    visited.add(edge.destination)
                    stack.push(edge.destination)
                    print("$stack")
                    vertex = stack.peek()
                    continue@loop
                }
            }

        } else {
            print("backtrack from $vertex")
            stack.pop()
            vertex = stack.peek()
            continue
        }

        print("backtrack from $vertex")
        stack.pop()
        vertex = stack.peek()
    }

    return stack
}