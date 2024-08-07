package org.example

class IntegerVerifier: Verifier {
    override var state: State = IntegerFirstDigit()

    override fun verify(string: String): Boolean {
        state = IntegerFirstDigit()
        return super.verify(string)
    }
}