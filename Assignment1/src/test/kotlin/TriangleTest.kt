import kotlin.test.*

internal class TriangleTest {

    @Test
    fun testArea(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)
        val testPoint3: Point = Point(4.0, 0.0)


        val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint3)
        val expected = 8.0

        assertEquals(expected, testTriangle.getArea())
    }

    @Test
    fun test0Area(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 2.0)
        val testPoint3: Point = Point(0.0, 4.0)


        assertFailsWith<IllegalArgumentException> { 
            val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint3)
        }
        
        val testPoint4: Point = Point(0.0, 0.0)

        assertFailsWith<IllegalArgumentException> { 
            val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint4)
        }
    }

    @Test
    fun testAttributes(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)
        val testPoint3: Point = Point(4.0, 0.0)


        val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint3)

        val expected = listOf(testPoint1.getPosition(), testPoint2.getPosition(), testPoint3.getPosition())

        assertEquals(expected, testTriangle.getPoints())
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)
        val testPoint3: Point = Point(4.0, 0.0)


        val testTriangle: Triangle = Triangle(testPoint1, testPoint2, testPoint3)

        println(testPoint1.getPosition())

        testTriangle.move(1.0, 1.0)

        assertEquals(Pair(1.0, 1.0), testPoint1.getPosition())
    }
}