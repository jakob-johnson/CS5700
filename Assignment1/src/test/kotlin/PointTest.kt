import kotlin.test.*

internal class PointTest {
    private val testPoint1: Point = Point(0.0, 0.0)
    private val testPoint2: Point = Point(1.0, 1.0)
    private val testPoint3: Point = Point(1.0, 4.0)

    @Test
    fun testGetPosition(){
        val expected = Pair(1.0, 4.0)
        assertEquals(expected, testPoint3.getPosition()) 
    }

}