import kotlin.math.PI

class Ellipse(
    private val p: Point,
    private val rx: Double,
    private val ry: Double
){
    init {
        require(this.rx > 0 && this.ry > 0){"Ellipse cannot have an area of 0"}
    }
    fun getAttributes(): Triple<Point, Double, Double>{
        return Triple(this.p, this.rx, this.ry)
    }
    
    fun getArea(): Double{
        return PI * this.rx * this.ry
    }

    fun move(x: Double, y: Double){
        this.p.move(x, y)
    }
}