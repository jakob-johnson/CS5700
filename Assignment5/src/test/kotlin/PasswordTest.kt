import org.example.PasswordVerifier
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PasswordTest {
    private val verifier = PasswordVerifier()
    @Test
    fun goodPassword(){
        assertTrue { verifier.verify("aaaaH!aa") }
        assertTrue { verifier.verify("1234567*9J") }
        assertTrue { verifier.verify("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH") }
        assertTrue { verifier.verify("!sdfjkl@@@@@@D") }
        assertTrue { verifier.verify("Asdfjk!;") }
    }

    @Test
    fun badPassword(){
        assertFalse { verifier.verify("") }
        assertFalse { verifier.verify("Asdfjkl;") }
        assertFalse { verifier.verify("Asdfjkl;@@@@@@") }
        assertFalse { verifier.verify("!sdfjkl@@@@@@D!") }
        assertFalse { verifier.verify("!sD2") }
    }
}