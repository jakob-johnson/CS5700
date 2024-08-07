package org.example

class EmailVerifier: Verifier {
    override var state: State = EmailFirstChar()

    override fun verify(string: String): Boolean {
        state = EmailFirstChar()
        return super.verify(string)
    }
}