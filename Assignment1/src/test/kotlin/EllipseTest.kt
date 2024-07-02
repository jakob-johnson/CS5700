import kotlin.test.*
import kotlin.math.PI

internal class EllipseTest {
    private val testPoint: Point = Point(1.toDouble() ,1.toDouble())

    private val testEllipse: Ellipse = Ellipse(testPoint, 1.toDouble(), 1.toDouble())

    @Test
    fun testArea(){
        val expected = PI
        assertEquals(expected, testEllipse.getArea())
    }
}