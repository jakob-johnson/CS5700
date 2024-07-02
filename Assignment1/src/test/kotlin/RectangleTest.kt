import kotlin.test.*

internal class RectangleTest {
    private val testPoint1: Point = Point(0.toDouble(), 0.toDouble())
    private val testPoint2: Point = Point(1.toDouble(), 4.toDouble())

    private val testRectangle: Rectangle = Rectangle(testPoint1, testPoint2)

    @Test
    fun testArea(){
        val expected = 4.toDouble()

        assertEquals(expected, testRectangle.getArea())

    }

}