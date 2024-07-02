import kotlin.math.abs

class Rectangle(
    private val p1: Point,
    private val p2: Point
){
    init {
        val (x1, y1) = p1.getPosition()
        val (x2, y2) = p2.getPosition()

        require(x1 != x2 && y1 != y2) {"Rectangle must have an area greater than 0"}
    }
    fun getPoints(): List<Pair<Double, Double>>{
        return listOf(p1.getPosition(), p2.getPosition())

        
    }

    fun getArea(): Double{
        val (x1, y1) = p1.getPosition()
        val (x2, y2) = p2.getPosition()

        return abs((y2 - y1)*(x2 - x1))
    }

    fun move(x: Double, y: Double) {
        p1.move(x, y)
        p2.move(x, y)
    }
}