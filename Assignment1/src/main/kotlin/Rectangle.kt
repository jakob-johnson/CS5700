class Rectangle(
    private val p1: Point,
    private val p2: Point
){
    init {
        val (x1, y1) = this.p1.getPosition()
        val (x2, y2) = this.p2.getPosition()

        require(x1 != x2 && y1 != y2) {"Rectangle must have an area greater than 0"}
    }
    fun getPoints(): List<Pair<Double, Double>>{
        return listOf(this.p1.getPosition(), this.p2.getPosition())

        
    }

    fun getArea(): Double{
        val (x1, y1) = this.p1.getPosition()
        val (x2, y2) = this.p2.getPosition()

        return (y2 - y1)*(x2 - x1)
    }

    fun move(x: Double, y: Double) {
        this.p1.move(x, y)
        this.p2.move(x, y)
    }
}