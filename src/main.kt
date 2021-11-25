var mapWithFigura = Array(20,{Array(10,{"."}) })
var mapJunk = Array(20,{Array(10,{"."}) })
var xPosition = 0
var yPosition = 3
var obj = Block_L()

fun main (){
    while(true){
        update(mapWithFigura,mapJunk,obj.blockUI,xPosition,yPosition)
        println("Введите команду: Space( ), Down(d), Left(l), Right(r), Stop(s)")
        if (!(xPosition + obj.height >=  20)) move(readLine().toString().uppercase())
        else new_age(mapJunk,obj.blockUI,xPosition,yPosition)
        junkCheck(mapJunk)
    }
}
fun junkCheck (actual_junk_map:Array<Array<String>>){
    var totalJunkOnLine = 0
    for (x in actual_junk_map.indices){
        for (i in actual_junk_map[x].indices){
            if (actual_junk_map[x][i] == "#") totalJunkOnLine +=1
            if (totalJunkOnLine >= 10) junkClear(actual_junk_map,x)
        }
        println("Мусора в $x : $totalJunkOnLine")
        totalJunkOnLine = 0
    }
}

fun junkClear (actual_junk_map:Array<Array<String>>, line : Int){
    for (x in line downTo 1){
        for (i in actual_junk_map[x].indices){
            actual_junk_map[x][i] = actual_junk_map[x-1][i]
        }
    }
}

fun move (enter:String){
        when (enter) {
            "SPACE", " " -> {
                obj.reverse()
            }
            "DOWN", "D" -> if (!collision(mapJunk,obj.blockUI,xPosition,yPosition)) new_age(mapJunk,obj.blockUI,xPosition,yPosition)
            "LEFT", "L" ->  {
                if(inTheWall(obj.blockUI,yPosition,"L")){
                    if (collision(mapJunk,obj.blockUI,xPosition,yPosition)){
                        yPosition-=1
                    }
                    else new_age(mapJunk,obj.blockUI,xPosition,yPosition)
                }
            }
            "RIGHT", "R" -> {
                if(inTheWall(obj.blockUI,yPosition,"R")) {
                    if (collision(mapJunk,obj.blockUI,xPosition,yPosition)){
                        yPosition+=1
                    }
                    else new_age(mapJunk,obj.blockUI,xPosition,yPosition)
                }
            }
        }
    xPosition+=1
}

fun inTheWall (block:Array<Array<String>>,yPos: Int, side: String) : Boolean{
    for (x in block.indices){
        for (i in block[x].indices){
            if (block[x][i] != "."){
                if (side == "L") if (yPos + i <= 0) return false
                if (side == "R") if (yPos + i >= 9) return false
            }
        }
    }
    return true
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