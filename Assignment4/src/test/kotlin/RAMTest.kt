import org.example.RAM
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNotEquals

@OptIn(ExperimentalUnsignedTypes::class)
class RAMTest {

    @Test
    internal fun testRom(){
        val ram = RAM()

        val arrayToLoad = UByteArray(60)

        var i = 0
        while (i < 60){
            ram.write(i, (i * i).toUByte())
            arrayToLoad[i] = (i * i).toUByte()
            i++
        }


        assertEquals(0u, ram.read(60))

        assertEquals(arrayToLoad[59], ram.read(59))

        assertNotEquals(arrayToLoad[59], ram.read(60))

        ram.write(60, arrayToLoad[59])

        assertEquals(arrayToLoad[59], ram.read(60))

        assertFails {
            ram.read(4100)
        }
    }
}
