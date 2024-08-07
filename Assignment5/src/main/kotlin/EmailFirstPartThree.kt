package org.example

class EmailFirstPartThree: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in " @."){
            verifier.state = Invalid()
        } else {
            verifier.state = EmailValid()
        }
    }
}