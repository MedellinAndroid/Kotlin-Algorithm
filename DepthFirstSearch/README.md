# Depth-First Search

Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. One starts at the root (selecting some arbitrary node as the root in the case of a graph) and explores as far as possible along each branch before backtracking.

A version of depth-first search was investigated in the 19th century by French mathematician Charles Pierre Trémaux as a strategy for solving mazes.

Algorithms that use depth-first search as a building block include:

* Finding connected components.
* Topological sorting.
* Finding 2-(edge or vertex)-connected components.
* Finding 3-(edge or vertex)-connected components.
* Finding the bridges of a graph.
* Generating words in order to plot the Limit Set of a Group.
* Finding strongly connected components.
* (Planarity testing)[https://en.wikipedia.org/wiki/Planarity_testing]
* Solving puzzles with only one solution, such as mazes. (DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.)
* Maze generation may use a randomized depth-first search.
* Finding biconnectivity in graphs.


Source: [Wikipedia page for Depth-First Search](https://en.wikipedia.org/wiki/Depth-first_search)

Kotlin playground [link](https://pl.kotl.in/TD9Z_iIB8)

#Code

```kotlin
import java.util.Stack

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



class AdjacencyList<T : Comparable<T>> : Graphable<T> {

    var adjacencyMap: MutableMap<Vertex<T>, MutableList<Edge<T>>> = mutableMapOf()

    private fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencyMap[source]?.add(edge)
    }

    private fun addUndirectedEdge(vertices: Pair<Vertex<T>, Vertex<T>>, weight: Double?) {
        val (source, destination) = vertices
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(data)

        adjacencyMap[vertex] ?: run {
            adjacencyMap[vertex] = mutableListOf()
        }

        return vertex
    }

    override fun add(type: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) = when (type) {
        is Directed -> addDirectedEdge(source, destination, weight)
        is Undirected -> addUndirectedEdge(Pair(source, destination), weight)
        else -> {}
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        val edges = adjacencyMap[source]
        edges?.let {

            it.forEach { edge ->
                if (edge.destination == destination) return edge.weight
            }

        }
        return null
    }

    override fun edges(source: Vertex<T>): MutableList<Edge<T>>? = adjacencyMap[source]

    override fun toString(): String {
        var result = ""
        for ((vertex, edges) in adjacencyMap) {
            var edgeString = ""
            for ((index, edge) in edges.withIndex()) {
                edgeString += if (index != edges.count() - 1) {
                    "${edge.destination}, "
                } else {
                    "${edge.destination}"
                }
            }
            result += "$vertex ---> [ $edgeString ] \n"
        }
        return result
    }
}



sealed class EdgeType

class Directed : EdgeType()
class Undirected : EdgeType()

data class Edge<T : Comparable<T>>(var source: Vertex<T>, var destination: Vertex<T>, val weight: Double?)


interface Graphable<T : Comparable<T>> {
    fun createVertex(data: T): Vertex<T>
    fun add(type: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double? = 0.0)
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
    fun edges(source: Vertex<T>): MutableList<Edge<T>>?
}


data class Vertex<T : Comparable<T>>(val data: T) {
    override fun toString(): String {
        return "$data"
    }
}
```