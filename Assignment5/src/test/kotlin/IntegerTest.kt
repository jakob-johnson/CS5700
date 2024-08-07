import org.example.IntegerVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class IntegerTest {
    private val verifier = IntegerVerifier()
    @Test
    fun goodInteger(){
        assertTrue { verifier.verify("12345") }
        assertTrue { verifier.verify("12012984091284901820490918239081209381281204810") }
        assertTrue { verifier.verify("1") }
    }

    @Test
    fun badInteger(){
        assertFalse { verifier.verify("0") }
        assertFalse { verifier.verify("adfsdf") }
        assertFalse { verifier.verify("1237a978") }
        assertFalse { verifier.verify("12394a") }
        assertFalse { verifier.verify("0123") }
    }

}