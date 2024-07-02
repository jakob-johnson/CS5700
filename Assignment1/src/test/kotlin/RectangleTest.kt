import kotlin.test.*

internal class RectangleTest {
    @Test
    fun testArea(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(1.0, 4.0)

        val testRectangle: Rectangle = Rectangle(testPoint1, testPoint2)

        val expected = 4.0

        assertEquals(expected, testRectangle.getArea())
    }

    @Test 
    fun test0Area(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 0.0)


        assertFailsWith<IllegalArgumentException> { 
            val testRectangle: Rectangle = Rectangle(testPoint1, testPoint2)
        }
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(4.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)


        val testRectangle: Rectangle = Rectangle(testPoint1, testPoint2)

        println(testPoint1.getPosition())

        testRectangle.move(1.0, 1.0)

        assertEquals(Pair(5.0, 1.0), testPoint1.getPosition())
        assertEquals(Pair(1.0, 5.0), testPoint2.getPosition())
    }

}