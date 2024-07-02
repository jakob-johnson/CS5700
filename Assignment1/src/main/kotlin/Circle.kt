import kotlin.math.PI

class Circle(
    private val p: Point,
    private val r: Double,
){
    init {
        require(this.r > 0){"Ellipse cannot have an area of 0"}
    }
    fun getAttributes(): Pair<Point, Double>{
        return Pair(this.p, this.r)
    }
    
    fun getArea(): Double{
        return PI * this.r * this.r
    }

    fun move(x: Double, y: Double){
        this.p.move(x, y)
    }
}