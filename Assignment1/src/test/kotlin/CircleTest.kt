import kotlin.test.*
import kotlin.math.PI

internal class CircleTest {
    private val testPoint: Point = Point(1.toDouble() ,1.toDouble())

    private val testCircle: Circle = Circle(testPoint, 1.toDouble())

    @Test
    fun testArea(){
        val expected = PI
        assertEquals(expected, testCircle.getArea())
    }
}