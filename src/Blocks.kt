open class Blocks(){
    open var block_ui = Array(4,{Array(4,{"."})})
}

class Block_L : Blocks() {
    var pose = 1
    init {
        block_ui[0] = arrayOf(".","#",".",".")
        block_ui[1] = arrayOf(".","#",".",".")
        block_ui[2] = arrayOf(".","#",".",".")
        block_ui[3] = arrayOf(".","#","#",".")
    }
    fun reverse(){
        if (pose == 1) {
            block_ui[0] = arrayOf(".", ".", ".", "#")
            block_ui[1] = arrayOf("#", "#", "#", "#")
            block_ui[2] = arrayOf(".", ".", ".", ".")
            block_ui[3] = arrayOf(".", ".", ".", ".")
            pose = 2
        }
        else if (pose == 2) {
            block_ui[0] = arrayOf(".", "#", "#", ".")
            block_ui[1] = arrayOf(".", ".", "#", ".")
            block_ui[2] = arrayOf(".", ".", "#", ".")
            block_ui[3] = arrayOf(".", ".", "#", ".")
            pose = 3
        }
        else if (pose == 3) {
            block_ui[0] = arrayOf("#", ".", ".", ".")
            block_ui[1] = arrayOf("#", "#", "#", "#")
            block_ui[2] = arrayOf(".", ".", ".", ".")
            block_ui[3] = arrayOf(".", ".", ".", ".")
            pose = 4
        }
        else if (pose == 4) {
            block_ui[0] = arrayOf(".","#",".",".")
            block_ui[1] = arrayOf(".","#",".",".")
            block_ui[2] = arrayOf(".","#",".",".")
            block_ui[3] = arrayOf(".","#","#",".")
            pose = 1
        }
    }
}