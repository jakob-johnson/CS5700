import kotlin.math.abs

class Square(
    private val p1: Point,
    private val p2: Point
){
    init {
        val (x1, y1) = p1.getPosition()
        val (x2, y2) = p2.getPosition()

        require(x1 != x2 && y1 != y2) {"Square must have an area greater than 0"}
        require(abs(x2 - x1) == abs(y2 - y1)) {"Square must have width == height"}
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