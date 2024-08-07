package org.example

class EmailFirstPartTwo: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in " @."){
            verifier.state = Invalid()
        } else {
            verifier.state = EmailPartTwo()
        }
    }
}