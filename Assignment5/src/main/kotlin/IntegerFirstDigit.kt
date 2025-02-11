package org.example

class IntegerFirstDigit: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "123456789"){
            verifier.state = IntegerValid()
        } else {
            verifier.state = Invalid()
        }
    }
}