import kotlin.math.PI

class Ellipse(
    private val p: Point,
    private val rx: Double,
    private val ry: Double
){
    init {
        require(rx > 0 && ry > 0){"Ellipse cannot have an area of 0"}
    }
    fun getAttributes(): Triple<Point, Double, Double>{
        return Triple(p, rx, ry)
    }
    
    fun getArea(): Double{
        return PI * rx * ry
    }

    fun move(x: Double, y: Double){
        p.move(x, y)
    }
}