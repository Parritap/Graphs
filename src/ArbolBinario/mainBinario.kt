package ArbolBinario

fun main() {
    val myList = listOf(3,10,14,1,6,4,7,13)
    val tree = ArbolBinario(8)
    myList.forEach { tree.inserValue(it) }


    println("INDORDER")
    tree.inOrder();

    println("\nPREORDER")
    tree.preOrder();

    println("\nPOSORDER")
    tree.posOrder();
}