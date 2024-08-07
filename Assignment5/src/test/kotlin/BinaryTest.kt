import org.example.BinaryVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class BinaryTest {
    private val verifier = BinaryVerifier()
    @Test
    fun goodBinary(){
        assertTrue { verifier.verify("1") }
        assertTrue { verifier.verify("11") }
        assertTrue { verifier.verify("101") }
        assertTrue { verifier.verify("1010101010101011111") }
        assertTrue { verifier.verify("101010101010000011111") }
    }

    @Test
    fun badBinary(){
        assertFalse { verifier.verify("1000") }
        assertFalse { verifier.verify("0001") }
        assertFalse { verifier.verify("01") }
        assertFalse { verifier.verify("0") }
        assertFalse { verifier.verify("01010100101101001101001101") }
        assertFalse { verifier.verify("10") }
        assertFalse { verifier.verify("10110") }
    }

}