import kotlin.test.*
import kotlin.math.PI

internal class EllipseTest {
    @Test
    fun testArea(){
        val testPoint: Point = Point(1.0 ,1.0)

        val testEllipse: Ellipse = Ellipse(testPoint, 1.0, 1.0)

        val expected = PI
        assertEquals(expected, testEllipse.getArea())
    }

    @Test
    fun test0Area(){
        val testPoint1: Point = Point(0.0, 0.0)

        assertFailsWith<IllegalArgumentException> { 
            val testEllipse: Ellipse = Ellipse(testPoint1, 0.0, 0.0)
        }
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(4.0, 0.0)


        val testEllipse: Ellipse = Ellipse(testPoint1, 1.0, 2.0)

        println(testPoint1.getPosition())

        testEllipse.move(1.0, 1.0)

        assertEquals(Pair(5.0, 1.0), testPoint1.getPosition())
    }

    @Test
    fun testAttributes(){
        val testPoint1: Point = Point(4.0, 0.0)


        val testEllipse: Ellipse = Ellipse(testPoint1, 1.0, 2.0)
        val expected = Triple(testPoint1, 1.0, 2.0)

        assertEquals(expected, testEllipse.getAttributes())
    }

}