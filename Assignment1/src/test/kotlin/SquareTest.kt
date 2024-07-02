import kotlin.test.*

internal class SquareTest {

    @Test
    fun testArea(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(4.0, 4.0)

        val testSquare: Square = Square(testPoint1, testPoint2)
        val expected = 16.0

        assertEquals(expected, testSquare.getArea())
    }

    @Test 
    fun test0Area(){
        val testPoint1: Point = Point(0.0, 0.0)
        val testPoint2: Point = Point(0.0, 0.0)


        assertFailsWith<IllegalArgumentException> { 
            val testSquare: Square = Square(testPoint1, testPoint2)
        }
    }

    @Test
    fun testNotSquare(){
        val testPoint1: Point = Point(0.0, 1.0)
        val testPoint2: Point = Point(4.0, 0.0)


        assertFailsWith<IllegalArgumentException> { 
            val testSquare: Square = Square(testPoint1, testPoint2)
        }
    }

    @Test
    fun testMove(){
        val testPoint1: Point = Point(4.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)


        val testSquare: Square = Square(testPoint1, testPoint2)

        println(testPoint1.getPosition())

        testSquare.move(1.0, 1.0)

        assertEquals(Pair(5.0, 1.0), testPoint1.getPosition())
        assertEquals(Pair(1.0, 5.0), testPoint2.getPosition())
    }

    @Test
    fun testAttributes(){
        val testPoint1: Point = Point(4.0, 0.0)
        val testPoint2: Point = Point(0.0, 4.0)


        val testSquare: Square = Square(testPoint1, testPoint2)

        val expected = listOf(testPoint1.getPosition(), testPoint2.getPosition())

        assertEquals(expected, testSquare.getPoints())
    }

}