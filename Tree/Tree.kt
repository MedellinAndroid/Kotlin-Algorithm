/**
 * Created by gazolla on 10/04/16.
 */
fun main() {
    val tree = TreeNode("beverages")

    val hotNode = TreeNode("hot")
    val coldNode = TreeNode("cold")

    val teaNode = TreeNode("tea")
    val coffeeNode = TreeNode("coffee")
    val chocolateNode = TreeNode("cocoa")

    val blackTeaNode = TreeNode("black")
    val greenTeaNode = TreeNode("green")
    val chaiTeaNode = TreeNode("chai")

    val sodaNode = TreeNode("soda")
    val milkNode = TreeNode("milk")

    val gingerAleNode = TreeNode("ginger ale")
    val bitterLemonNode = TreeNode("bitter lemon")

    tree.addChild(hotNode)
    tree.addChild(coldNode)

    hotNode.addChild(teaNode)
    hotNode.addChild(coffeeNode)
    hotNode.addChild(chocolateNode)

    coldNode.addChild(sodaNode)
    coldNode.addChild(milkNode)

    teaNode.addChild(blackTeaNode)
    teaNode.addChild(greenTeaNode)
    teaNode.addChild(chaiTeaNode)

    sodaNode.addChild(gingerAleNode)
    sodaNode.addChild(bitterLemonNode)

    println(tree)
}

class TreeNode<T>(value: T) {
    var value: T = value

    var parent: TreeNode<T>? = null

    var children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node: TreeNode<T>) {
        children.add(node)
        node.parent = this
    }

    override fun toString(): String {
        var s = "$value"
        if (children.isNotEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }
}
