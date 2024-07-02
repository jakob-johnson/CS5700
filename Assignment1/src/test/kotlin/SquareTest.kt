import kotlin.test.*

internal class SquareTest {
    private val testPoint1: Point = Point(0.toDouble(), 0.toDouble())
    private val testPoint2: Point = Point(4.toDouble(), 4.toDouble())

    private val testSquare: Square = Square(testPoint1, testPoint2)

    @Test
    fun testArea(){
        val expected = 16.toDouble()

        assertEquals(expected, testSquare.getArea())
    }
}