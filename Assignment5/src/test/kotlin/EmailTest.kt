import org.example.EmailVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class EmailTest {
    private val verifier = EmailVerifier()
    @Test
    fun goodEmail(){
        assertTrue { verifier.verify("a@b.c") }
        assertTrue { verifier.verify("joseph.ditton@usu.edu") }
        assertTrue { verifier.verify("{}*\$.&\$*(@*\$%&.*&*") }
    }

    fun badEmail(){
        assertFalse { verifier.verify("") }
        assertFalse { verifier.verify("@b.c") }
        assertFalse { verifier.verify("A@.c") }
        assertFalse { verifier.verify("A@b.") }
        assertFalse { verifier.verify("A@bc") }
        assertFalse { verifier.verify("Apple @b.c") }
        assertFalse { verifier.verify("App@le@b.c") }
        assertFalse { verifier.verify("App@le b.c") }
        assertFalse { verifier.verify("App@le.b.c") }
    }
}