package org.example

class BinaryFirstDigit: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == "1") {
            verifier.state = BinaryValid()
        } else {
            verifier.state = Invalid()
        }
    }

}