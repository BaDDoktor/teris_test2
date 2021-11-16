fun main (){
    var map = Array(20,{Array(10,{"."}) })
    var xPosition = 0
    var yPosition = 3
    var obiekt = Block_L()

    while(true){
        update(map,obiekt.block_ui,xPosition,yPosition)
        println("Введите команду: Space, Down, Left, Right, Stop")
        var input = readLine().toString().uppercase()
        if (input == "SPACE") obiekt.reverse()
        else if (input == "DOWN") xPosition+=1
        else if (input == "LEFT") yPosition-=1
        else if (input == "RIGHT") yPosition+=1
        else if (input == "STOP") break
    }
}


fun collision (){
    print("asdasd")
}

fun update(map_new : Array<Array<String>>, block : Array<Array<String>>, xPos : Int,yPos : Int){
    for (x in map_new.indices){
        for(i in map_new[x].indices) map_new[x][i] = "."
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
