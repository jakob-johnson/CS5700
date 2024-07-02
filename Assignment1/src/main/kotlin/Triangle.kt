import kotlin.math.abs

class Triangle(
    private val p1: Point,
    private val p2: Point,
    private val p3: Point,
){
    init {
        val (x1, y1) = this.p1.getPoints()
        val (x2, y2) = this.p2.getPoints()
        val (x3, y3) = this.p3.getPoints()
        require(!(x1 == x2 && x2 == x3) || !(y1 == y2 && y2 == y3)) {"Triangle must have area greater than 0"}
    }

    fun getPoints(): List<Pair<Double, Double>>{
        val pointsList = listOf(this.p1.getPosition(), this.p2.getPosition(), this.p3.getPosition())
    }
    
    fun getArea(): Double{
        val (x1, y1) = this.p1.getPoints()
        val (x2, y2) = this.p2.getPoints()
        val (x3, y3) = this.p3.getPoints()

        return abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2
    }

    fun move(x: Double, y: Double){
        this.p1.move(x, y)
        this.p2.move(x, y)
        this.p3.move(x, y)
    }
}