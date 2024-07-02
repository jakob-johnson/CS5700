class Square(
    private val p1: Point,
    private val p2: Point
){
    init {
        val (x1, y1) = this.p1.getPosition()
        val (x2, y2) = this.p2.getPosition()

        require(x1 != x2 && y1 != y2) {"Square must have an area greater than 0"}
        require(x2 - x1 == y2 - y1) {"Square must have width == height"}
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