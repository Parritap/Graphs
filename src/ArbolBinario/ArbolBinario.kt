package ArbolBinario

/**
 * Binary tree
 *
 * @property value
 * @property leftNode
 * @property rigthNode
 * @constructor Create empty Binary tree
 */
class ArbolBinario(
    var value: Int,
    var leftNode: ArbolBinario? = null,
    var rigthNode: ArbolBinario? = null
) {

    /**
     * Inserts a value in the tree.
     *
     * @param value
     */
    fun inserValue (value : Int ) : Unit {
        if ( value < this.value ) {
            if ( this.leftNode == null ) {
                this.leftNode = ArbolBinario(value)
            } else {
                this.leftNode!!.inserValue(value)
            }
        } else {
            if ( this.rigthNode == null ) {
                this.rigthNode = ArbolBinario(value)
            } else {
                this.rigthNode!!.inserValue(value)
            }
        }
    }


    /**
     * Pos order
     *
     */
    fun posOrder() {
        leftNode?.posOrder()
        rigthNode?.posOrder()
        print("$value, ")
    }

    /**
     * Pre order
     *
     */
    fun preOrder() {
        print("$value, ")
        leftNode?.preOrder()
        rigthNode?.preOrder()
    }

    /**
     * In order
     *
     */
    fun inOrder() {
        leftNode?.inOrder()
        print("$value, ")
        rigthNode?.inOrder()
    }

}