package org.example

class FloatingDigit: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == "."){
            verifier.state = FloatingDecimal()
        } else if (char !in "0123456789"){
            verifier.state = Invalid()
        }
    }
}