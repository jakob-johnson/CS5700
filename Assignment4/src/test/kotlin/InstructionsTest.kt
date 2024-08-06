import org.example.Computer
import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class testInstructions {


    @Test
    fun testStore() {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        assertFailsWith<IndexOutOfBoundsException> { computer.instructions[0]?.executeInstruction(8u, 100u, computer) }
        assertEquals(2u, computer.getRegister(1))


    }

    @Test
    fun testAdd() {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        computer.instructions[0]?.executeInstruction(0u, 2u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[1]?.executeInstruction(16u, 16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(4u, computer.getRegister(0))
    }

    @Test
    fun testSub() {
        val computer = Computer()

        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        computer.instructions[0]?.executeInstruction(0u, 16u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[2]?.executeInstruction(16u, 16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(14u, computer.getRegister(0))
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    @Test
    fun testReadAndWrite() {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        computer.instructions[0]?.executeInstruction(0u, 5u, computer)
        // RAM
        // Writing
        computer.instructions[4]?.executeInstruction(1u, 0u, computer)

        // testing through read operation
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        assertEquals(2u, computer.getRegister(2))
        // ROM
        // Writing
        computer.setM()
        computer.instructions[4]?.executeInstruction(0u, 0u, computer)

        // testing through read operation
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        assertEquals(5u, computer.getRegister(3))


    }

    @Test
    fun testJump() {

        val computer = Computer()
        // Setting the program counter to be '212', but converts to decimal for byte representation
        computer.instructions[5]?.executeInstruction(18u, 18u, computer)
        assertEquals("212".toUShort(16), computer.getP())
        assertFailsWith<IllegalArgumentException> { computer.instructions[5]?.executeInstruction(18u, 17u, computer) }

    }

    @Test
    fun testReadKeyboard() {
        // NOTE: Can't test this without mocking readLine() in the method. Not really sure how to do that :/
    }

    @Test
    fun testSwitchMemory() {
        val computer = Computer()
        assertEquals(false, computer.getM())
        computer.instructions[7]?.executeInstruction(0u, 0u, computer)
        assertEquals(true, computer.getM())
    }

    @Test
    fun testSkipEqual() {
        val computer = Computer()
        // Not equal, so don't skip
        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        computer.instructions[0]?.executeInstruction(0u, 16u, computer)
        computer.instructions[8]?.executeInstruction(0u, 16u, computer)
        assertEquals(6, computer.getP().toInt())
        // Equal, so do skip
        computer.instructions[0]?.executeInstruction(1u, 16u, computer)
        computer.instructions[8]?.executeInstruction(0u, 16u, computer)
        assertEquals(12, computer.getP().toInt())
    }

    @Test
    fun testSkipNotEqual() {
        val computer = Computer()
        // Not equal, so skip
        computer.instructions[0]?.executeInstruction(1u, 2u, computer)
        computer.instructions[0]?.executeInstruction(0u, 16u, computer)
        computer.instructions[9]?.executeInstruction(0u, 16u, computer)
        assertEquals(8u, computer.getP())
        // Equal, so do skip
        computer.instructions[0]?.executeInstruction(1u, 16u, computer)
        computer.instructions[9]?.executeInstruction(0u, 16u, computer)
        assertEquals(12u, computer.getP())
    }

    @Test
    fun testSetA() {
        val computer = Computer()
        // Setting the Address to be '212', but converts to decimal for byte representation
        computer.instructions[10]?.executeInstruction(42u, 52u, computer)
        assertEquals("A34".toInt(16).toUShort(), computer.getA())
    }

    @Test
    fun testSetT() {
        val computer = Computer()
        // Setting the Address to be '212', but converts to decimal for byte representation
        computer.instructions[11]?.executeInstruction(42u, 52u, computer)
        assertEquals("A3".toInt(16), computer.getT().toInt())
    }

    @Test
    fun testReadT() {
        val computer = Computer()
        computer.instructions[11]?.executeInstruction(42u, 52u, computer)
        computer.instructions[12]?.executeInstruction(0u, 0u, computer)
        assertEquals("A3".toInt(16), computer.getRegister(0).toInt())
    }

    @Test
    fun testConvertToBase10() {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u, 112u, computer)
        computer.instructions[13]?.executeInstruction(0u, 0u, computer)
        computer.instructions[3]?.executeInstruction(1u, 0u, computer)
        computer.setA(computer.getA().toInt() + 1)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA().toInt() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA().toInt() - 2)

        assertEquals(1u, computer.getRegister(1))
        assertEquals(1u, computer.getRegister(2))
        assertEquals(2u, computer.getRegister(3))

        // Switch to separate memory
        computer.setM()
        computer.instructions[0]?.executeInstruction(0u, 112u, computer)
        computer.instructions[13]?.executeInstruction(0u, 0u, computer)
        computer.instructions[3]?.executeInstruction(1u, 0u, computer)
        computer.setA(computer.getA().toInt() + 1)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA().toInt() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA().toInt() - 2)

        assertEquals(1u, computer.getRegister(1))
        assertEquals(1u, computer.getRegister(2))
        assertEquals(2u, computer.getRegister(3))

    }

    @Test
    fun testConvertByteToAscii() {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u, 2u, computer)
        //assertEquals(2u ,computer.getRegisterValue(1))
        computer.instructions[14]?.executeInstruction(16u, 16u, computer)
        //  assertFailsWith<IndexOutOfBoundsException> { computer.instructions[1]?.executeInstruction(8u,100u, computer)}
        assertEquals(50u, computer.getRegister(1))

        computer.instructions[0]?.executeInstruction(0u, 14u, computer)

        computer.instructions[14]?.executeInstruction(16u, 16u, computer)

        assertEquals(69u, computer.getRegister(1))

        computer.instructions[0]?.executeInstruction(0u, 17u, computer)

        assertFailsWith<IllegalArgumentException> { computer.instructions[14]?.executeInstruction(16u, 16u, computer) }
    }

    @Test
    fun testDraw() {
        val computer = Computer()
        computer.instructions[0]?.executeInstruction(0u, 2u, computer)
        computer.instructions[0]?.executeInstruction(1u, 6u, computer)
        computer.instructions[15]?.executeInstruction(0u, 0u, computer)
        computer.instructions[15]?.executeInstruction(1u, 1u, computer)
        computer.instructions[3]?.executeInstruction(2u, 0u, computer)
        computer.setA(computer.getA().toInt() + 1)
        computer.instructions[3]?.executeInstruction(3u, 0u, computer)
        computer.setA(computer.getA().toInt() - 1)
        assertEquals(2u, computer.getRegister(2))
        assertEquals(6u, computer.getRegister(3))
        assertEquals(2u, computer.getScreenValue(0, 0))
        assertEquals(6u, computer.getScreenValue(0, 1))
        assertFailsWith<IllegalArgumentException> { computer.getScreenValue(8, 8) }
        computer.instructions[0]?.executeInstruction(1u, 213u, computer)
        assertFailsWith<IllegalArgumentException> { computer.instructions[15]?.executeInstruction(1u, 1u, computer) }

        // Showing if we attempt to draw out of bounds
        assertFailsWith<IllegalArgumentException> { computer.instructions[15]?.executeInstruction(1u, 196u, computer) }
    }
}