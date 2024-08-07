package org.example

class EmailPartOne: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == " "){
            verifier.state = Invalid()
        } else if (char == "@"){
           verifier.state = EmailFirstPartTwo()
        }
    }
}