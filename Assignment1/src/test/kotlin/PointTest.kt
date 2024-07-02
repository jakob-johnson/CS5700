import kotlin.test.*

internal class PointTest {
    @Test
    fun testGetPosition(){
        val testPoint1: Point = Point(1.0, 4.0)

        val expected = Pair(1.0, 4.0)
        assertEquals(expected, testPoint1.getPosition()) 
    }

    @Test
    fun testClone(){
        val testPoint1: Point = Point(1.0, 4.0)

        val testPoint2: Point = testPoint1.clone()

        assertEquals(testPoint1.getPosition(), testPoint2.getPosition())

        testPoint1.move(1.0, 1.0)

        assertNotEquals(testPoint1.getPosition(), testPoint2.getPosition())
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(1.0, 4.0)

        val testPoint2: Point = Point(1.0, 4.0)

        assertEquals(testPoint1.getPosition(), testPoint2.getPosition())

        testPoint1.move(1.0, 1.0)

        assertNotEquals(testPoint1.getPosition(), testPoint2.getPosition())

    }

}