class Point(
    private var xPos: Double,
    private var yPos: Double
){
    fun getPosition(): Pair<Double, Double>{
        return Pair(this.xPos, this.yPos)
    }

    fun clone(): Point{
        return Point(this.xPos, this.yPos)
    }

    fun move(x: Double, y: Double){
        this.xPos += x
        this.yPos += y
    }
}