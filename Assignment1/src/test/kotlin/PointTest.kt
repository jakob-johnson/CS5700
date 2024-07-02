import kotlin.test.*

internal class PointTest {
    private val testPoint1: Point = Point(0.toDouble(), 0.toDouble())
    private val testPoint2: Point = Point(1.toDouble(), 1.toDouble())
    private val testPoint3: Point = Point(1.toDouble(), 4.toDouble())

    @Test
    fun testGetPosition(){
        val expected = Pair(1.toDouble(), 4.toDouble())
        assertEquals(expected, testPoint3.getPosition()) 
    }

}