import kotlin.test.*
import kotlin.math.PI

internal class EllipseTest {
    private val testPoint: Point = Point(1.0 ,1.0)

    private val testEllipse: Ellipse = Ellipse(testPoint, 1.0, 1.0)

    @Test
    fun testArea(){
        val expected = PI
        assertEquals(expected, testEllipse.getArea())
    }

    fun test0Area(){
        val testPoint1: Point = Point(0.0, 0.0)

        assertFailsWith<IllegalArgumentException> { 
            val testEllipse: Ellipse = Ellipse(testPoint1, 0.0, 0.0)
        }
    }
}