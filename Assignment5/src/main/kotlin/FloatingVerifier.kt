package org.example

class FloatingVerifier: Verifier {
    override var state: State = FloatingFirstDigit()

    override fun verify(string: String): Boolean {
        state = FloatingFirstDigit()
        return super.verify(string)
    }
}