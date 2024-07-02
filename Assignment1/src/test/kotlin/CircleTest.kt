import kotlin.test.*
import kotlin.math.PI

internal class CircleTest {
    private val testPoint: Point = Point(1.0 ,1.0)

    private val testCircle: Circle = Circle(testPoint, 1.0)

    @Test
    fun testArea(){
        val expected = PI
        assertEquals(expected, testCircle.getArea())
    }
}