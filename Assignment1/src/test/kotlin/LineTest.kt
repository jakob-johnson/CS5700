import kotlin.test.*

internal class LineTest {

    @Test
    fun testSlope(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(1.0, 1.0)

        val testLine: Line = Line(testPoint1, testPoint2)

        assertEquals(1.0, testLine.getSlope())
    }

    @Test
    fun testLength(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 1.0)

        val testLine: Line = Line(testPoint1, testPoint2)

        assertEquals(1.0, testLine.getLength())
    }

    @Test
    fun test0Length(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 0.0)

        assertFailsWith<IllegalArgumentException> { 
            val testLine: Line = Line(testPoint1, testPoint2)
        }
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(4.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)


        val testLine: Line = Line(testPoint1, testPoint2)

        println(testPoint1.getPosition())

        testLine.move(1.0, 1.0)

        assertEquals(Pair(5.0, 1.0), testPoint1.getPosition())
        assertEquals(Pair(1.0, 5.0), testPoint2.getPosition())
    }

    @Test
    fun testAttributes(){
        val testPoint1: Point = Point(4.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)


        val testLine: Line = Line(testPoint1, testPoint2)

        val expected = listOf(testPoint1.getPosition(), testPoint2.getPosition())

        assertEquals(expected, testLine.getPoints())
    }
}