import kotlin.math.abs

class Triangle(
    private val p1: Point,
    private val p2: Point,
    private val p3: Point,
){
    init {
        require(!(getArea() == 0.0)) {"Triangle must have area greater than 0"}
    }

    fun getPoints(): List<Pair<Double, Double>>{
        return listOf(this.p1.getPosition(), this.p2.getPosition(), this.p3.getPosition())
    }
    
    fun getArea(): Double{
        val (x1, y1) = this.p1.getPosition()
        val (x2, y2) = this.p2.getPosition()
        val (x3, y3) = this.p3.getPosition()

        return abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2
    }

    fun move(x: Double, y: Double){
        this.p1.move(x, y)
        this.p2.move(x, y)
        this.p3.move(x, y)
    }
}