import kotlin.test.*

internal class LineTest {
    private val testPoint1: Point = Point(0.toDouble(), 0.toDouble())
    private val testPoint2: Point = Point(1.toDouble(), 1.toDouble())

    private val testLine: Line = Line(testPoint1, testPoint2)

    @Test
    fun testSlope(){
        assertEquals(1.toDouble(), testLine.getSlope())
    }
}