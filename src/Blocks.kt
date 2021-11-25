open class Blocks(){
    open var blockUI = Array(4,{Array(4,{"."})})
    var height = 0
        get() {
            var z = 0
            for (x in blockUI.indices){
                for(i in blockUI[x].indices){
                    if (blockUI[x][i] != ".") z = x + 1
                }
            }
            return z
        }
    var width = 0
        get() {
            var z = 0
            for (x in blockUI.indices){
                for(i in blockUI[x].indices){
                    if (blockUI[x][i] != ".")  z = i + 1
                }
            }
            return z
        }

}

class Block_L : Blocks() {
    var pose = 1
    init {
        blockUI[0] = arrayOf(".","#",".",".")
        blockUI[1] = arrayOf(".","#",".",".")
        blockUI[2] = arrayOf(".","#",".",".")
        blockUI[3] = arrayOf(".","#","#",".")
    }
    fun reverse(){
        if (pose == 1) {
            blockUI[0] = arrayOf(".", ".", ".", "#")
            blockUI[1] = arrayOf("#", "#", "#", "#")
            blockUI[2] = arrayOf(".", ".", ".", ".")
            blockUI[3] = arrayOf(".", ".", ".", ".")
            pose = 2
        }
        else if (pose == 2) {
            blockUI[0] = arrayOf(".", "#", "#", ".")
            blockUI[1] = arrayOf(".", ".", "#", ".")
            blockUI[2] = arrayOf(".", ".", "#", ".")
            blockUI[3] = arrayOf(".", ".", "#", ".")
            pose = 3
        }
        else if (pose == 3) {
            blockUI[0] = arrayOf("#", ".", ".", ".")
            blockUI[1] = arrayOf("#", "#", "#", "#")
            blockUI[2] = arrayOf(".", ".", ".", ".")
            blockUI[3] = arrayOf(".", ".", ".", ".")
            pose = 4
        }
        else if (pose == 4) {
            blockUI[0] = arrayOf(".","#",".",".")
            blockUI[1] = arrayOf(".","#",".",".")
            blockUI[2] = arrayOf(".","#",".",".")
            blockUI[3] = arrayOf(".","#","#",".")
            pose = 1
        }
    }
}