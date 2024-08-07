package org.example

class EmailFirstChar: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "@ "){
            verifier.state = Invalid()
        } else {
            verifier.state = EmailPartOne()
        }
    }
}