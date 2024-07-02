import kotlin.test.*

internal class LineTest {
    private val testPoint1: Point = Point(0.0, 0.0)
    private val testPoint2: Point = Point(1.0, 1.0)

    private val testLine: Line = Line(testPoint1, testPoint2)

    @Test
    fun testSlope(){
        assertEquals(1.0, testLine.getSlope())
    }
}