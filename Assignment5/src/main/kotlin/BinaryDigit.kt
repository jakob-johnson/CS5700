package org.example

class BinaryDigit: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == "1"){
            verifier.state = BinaryValid()
        } else if (char != "0"){
            verifier.state = Invalid()
        }
    }
}