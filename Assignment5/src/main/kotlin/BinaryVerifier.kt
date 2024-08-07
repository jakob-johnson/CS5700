package org.example

class BinaryVerifier: Verifier {
    override var state: State = BinaryFirstDigit()

    override fun verify(string: String): Boolean {
        state = BinaryFirstDigit()
        return super.verify(string)
    }
}