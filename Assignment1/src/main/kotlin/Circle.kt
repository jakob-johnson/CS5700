import kotlin.math.PI

class Circle(
    private val p: Point,
    private val r: Double,
){
    init {
        require(r > 0){"Ellipse cannot have an area of 0"}
    }
    fun getAttributes(): Pair<Point, Double>{
        return Pair(p, r)
    }
    
    fun getArea(): Double{
        return PI * r * r
    }

    fun move(x: Double, y: Double){
        p.move(x, y)
    }
}