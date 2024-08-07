import org.example.FloatingVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class FloatTest {
    private val verifier = FloatingVerifier()
    @Test
    fun goodFloat(){
        assertTrue { verifier.verify("0.0") }
        assertTrue { verifier.verify("12310.4123") }
        assertTrue { verifier.verify("10.410192830912830192830912823") }
        assertTrue { verifier.verify("1019238910.410192830912830192830912823") }
    }

    @Test
    fun badFloat(){
        assertFalse { verifier.verify(".0") }
        assertFalse { verifier.verify(".") }
        assertFalse { verifier.verify("123.") }
        assertFalse { verifier.verify(".123") }
        assertFalse { verifier.verify("0908.123") }
        assertFalse { verifier.verify("0908.12.9083") }
        assertFalse { verifier.verify("908.12a9083") }
        assertFalse { verifier.verify("9a08.129083") }
        assertFalse { verifier.verify("908.a129083") }
    }
}