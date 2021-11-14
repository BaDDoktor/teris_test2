import kotlin.random.Random

fun main (){
    var map = Array(20,{Array(10,{"."}) })
    //var figura = Array(4,{Array(4,{"."}) })
    var xPosition = 0
    var yPosition = 3
    var obiekt = Block_L(xPosition,yPosition)

    //create_fig(figura)
    update(map,obiekt.figura,xPosition,yPosition)

}

fun update(map_new : Array<Array<String>>, block : Array<Array<String>>, xPos : Int,yPos : Int){
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


fun create_fig (fig : Array<Array<String>>) : Array<Array<String>>{
    val i = Random.nextInt(1,7)

    if (i == 1) {
        fig[0] = kotlin.arrayOf(".", "#", ".", ".")
        fig[1] = kotlin.arrayOf(".", "#", ".", ".")
        fig[2] = kotlin.arrayOf(".", "#", ".", ".")
        fig[3] = kotlin.arrayOf(".", "#", "#", ".")
    }

    if (i == 2) {
        fig[0] = kotlin.arrayOf(".", "#", ".", ".")
        fig[1] = kotlin.arrayOf(".", "#", ".", ".")
        fig[2] = kotlin.arrayOf(".", "#", ".", ".")
        fig[3] = kotlin.arrayOf(".", "#", ".", ".")
    }

    if (i == 3) {
        fig[0] = kotlin.arrayOf(".", "#", "#", ".")
        fig[1] = kotlin.arrayOf(".", "#", "#", ".")
        fig[2] = kotlin.arrayOf(".", ".", ".", ".")
        fig[3] = kotlin.arrayOf(".", ".", ".", ".")
    }

    if (i == 4) {
        fig[0] = kotlin.arrayOf(".", ".", "#", "#")
        fig[1] = kotlin.arrayOf(".", "#", "#", ".")
        fig[2] = kotlin.arrayOf(".", ".", ".", ".")
        fig[3] = kotlin.arrayOf(".", ".", ".", ".")
    }

    if (i == 5) {
        fig[0] = kotlin.arrayOf(".", "#", "#", ".")
        fig[1] = kotlin.arrayOf(".", ".", "#", "#")
        fig[2] = kotlin.arrayOf(".", ".", ".", ".")
        fig[3] = kotlin.arrayOf(".", ".", ".", ".")
    }

    if (i == 6) {
        fig[0] = kotlin.arrayOf(".", ".", "#", ".")
        fig[1] = kotlin.arrayOf(".", ".", "#", ".")
        fig[2] = kotlin.arrayOf(".", ".", "#", ".")
        fig[3] = kotlin.arrayOf(".", "#", "#", ".")
    }

    if (i == 7) {
        fig[0] = kotlin.arrayOf(".", "#", "#", "#")
        fig[1] = kotlin.arrayOf(".", ".", "#", ".")
        fig[2] = kotlin.arrayOf(".", ".", ".", ".")
        fig[3] = kotlin.arrayOf(".", ".", ".", ".")
    }

    return fig
}