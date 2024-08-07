package org.example

class FloatingDecimal : State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "0123456789"){
            verifier.state = FloatingValid()
        } else {
            verifier.state = Invalid()
        }
    }
}