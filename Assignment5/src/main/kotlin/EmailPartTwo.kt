package org.example

class EmailPartTwo: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in " @"){
            verifier.state = Invalid()
        } else if (char == "."){
            verifier.state = EmailFirstPartThree()
        }
    }
}