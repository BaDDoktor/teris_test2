var mapWithFigura = Array(20,{Array(10,{"."}) })
var mapJunk = Array(20,{Array(10,{"."}) })
var xPosition = 0
var yPosition = 3
var obj = Block_L()

fun main (){
    while(true){
        update(mapWithFigura,mapJunk,obj.blockUI,xPosition,yPosition)
        if (collision(mapJunk,obj.blockUI,xPosition,yPosition)) {
            println("Введите команду: Space, Down, Left, Right, Stop")
            when (readLine().toString().uppercase()) {
                "SPACE", " " -> obj.reverse()
                "DOWN", "D" -> xPosition += 1
                "LEFT", "L" ->  yPosition -= 1
                "RIGHT", "R" -> yPosition += 1
                "STOP", "S" -> break
            }
        }
        else new_age(mapJunk,obj.blockUI,xPosition,yPosition)
    }
}


fun move (){

}

fun new_age (actual_junk_map:Array<Array<String>>, block:Array<Array<String>>, xPos:Int, yPos:Int){
    for (x in block.indices){
        for(i in block[x].indices){
            if (block[x][i] != ".") actual_junk_map[xPos+x][yPos+i] = block[x][i]
        }
    }
    xPosition = 0
    yPosition = 3
    obj = Block_L()
}

fun collision (actual_junk_map:Array<Array<String>>, block:Array<Array<String>>, xPos:Int, yPos:Int) : Boolean{
    if (xPos + obj.height >=  20) return false
    if (yPos <= 0 || yPos + obj.width >= 10) return false
    for (x in block.indices){
        for(i in block[x].indices){
            if (block[x][i] != ".")
                if (actual_junk_map[xPos+x+1][yPos+i] != ".") return false
        }
    }
    debug(obj.width,obj.height,"test")
    return true
}

fun update(map_new : Array<Array<String>>,map_junk : Array<Array<String>>, block : Array<Array<String>>, xPos : Int,yPos : Int){
    for (x in map_new.indices){
        for(i in map_new[x].indices) {
            map_new[x][i] = "."
            map_new[x][i] = map_junk[x][i]
        }
    }
    for (x in block.indices){
        for(i in block[x].indices){
            if (block[x][i] != ".") map_new[xPos+x][yPos+i] = block[x][i]
        }
    }
    for (row in map_new){
        for (cell in row) print(cell)
        println()
    }
}


fun debug (xPos : Int,yPos : Int, text:String){
    println("Debug #1:$xPos #2:$yPos $text")
}