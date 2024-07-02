import kotlin.test.*

internal class SquareTest {
    private val testPoint1: Point = Point(0.0, 0.0)
    private val testPoint2: Point = Point(4.0, 4.0)

    private val testSquare: Square = Square(testPoint1, testPoint2)

    @Test
    fun testArea(){
        val expected = 16.0

        assertEquals(expected, testSquare.getArea())
    }
}