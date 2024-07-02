import kotlin.test.*

internal class RectangleTest {
    private val testPoint1: Point = Point(0.0, 0.0)
    private val testPoint2: Point = Point(1.0, 4.0)

    private val testRectangle: Rectangle = Rectangle(testPoint1, testPoint2)

    @Test
    fun testArea(){
        val expected = 4.0

        assertEquals(expected, testRectangle.getArea())

    }

}