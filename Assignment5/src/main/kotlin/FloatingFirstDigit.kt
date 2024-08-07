package org.example

class FloatingFirstDigit: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        when (char) {
            in "123456789" -> {
                verifier.state = FloatingDigit()
            }
            in "0" -> {
                verifier.state = FloatingFirst0()
            }
            else -> {
                verifier.state = Invalid()
            }
        }
    }
}