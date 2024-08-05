import org.example.ROM
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNotEquals

@OptIn(ExperimentalUnsignedTypes::class)
class ROMTest {

    @Test
    internal fun testRom(){
        val rom = ROM()

        val arrayToLoad = UByteArray(60)

        var i = 0
        while (i < 60){
            arrayToLoad[i] = (i * i).toUByte()
            i++
        }

        rom.load(arrayToLoad)

        assertEquals(0u, rom.read(60))

        assertEquals(arrayToLoad[59], rom.read(59))

        assertNotEquals(arrayToLoad[59], rom.read(60))

        rom.write(60, arrayToLoad[59])

        assertEquals(arrayToLoad[59], rom.read(60))

        assertFails {
            rom.read(4100)
        }
    }
}