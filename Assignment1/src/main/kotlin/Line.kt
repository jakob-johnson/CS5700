import kotlin.math.sqrt
import kotlin.math.pow

class Line(
    private val p1: Point,
    private val p2: Point
){
    init {
        require(p1.getPosition() != p2.getPosition()) {"A line cannot have 0 length"}
    }

    fun getPoints(): List<Pair<Double, Double>>{
        return listOf(p1.getPosition(), p2.getPosition())
    }

    fun getSlope(): Double{
        val (x1, y1) = p1.getPosition()
        val (x2, y2) = p2.getPosition()

        return (y2 - y1)/(x2 - x1)
    }

    fun getLength(): Double{
        val (x1, y1) = p1.getPosition()
        val (x2, y2) = p2.getPosition()

        return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    }

    fun move(x: Double, y: Double) {
        p1.move(x, y)
        p2.move(x, y)
    }
}