package org.example

class FloatingFirst0 : State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == "."){
            verifier.state = FloatingDecimal()
        } else {
            verifier.state = Invalid()
        }
    }
}