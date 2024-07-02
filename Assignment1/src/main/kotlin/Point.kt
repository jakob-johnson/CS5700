class Point(
    private var xPos: Double,
    private var yPos: Double
){
    fun getPosition(): Pair<Double, Double>{
        return Pair(xPos, yPos)
    }

    fun clone(): Point{
        return Point(xPos, yPos)
    }

    fun move(x: Double, y: Double){
        xPos += x
        yPos += y
    }
}