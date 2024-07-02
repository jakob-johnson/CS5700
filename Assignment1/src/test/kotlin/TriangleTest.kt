import kotlin.test.*

internal class TriangleTest {
    private val testPoint1: Point = Point(0.toDouble(), 0.toDouble())
    private val testPoint2: Point = Point(0.toDouble(), 4.toDouble())
    private val testPoint3: Point = Point(4.toDouble(), 0.toDouble())


    private val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint3)

    @Test
    fun testArea(){
        val expected = 8.toDouble()

        assertEquals(expected, testTriangle.getArea())
    }
}