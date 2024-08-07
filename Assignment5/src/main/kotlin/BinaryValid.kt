package org.example

class BinaryValid : Valid {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char == "0"){
            verifier.state = BinaryDigit()
        } else if (char != "1") {
            verifier.state = Invalid()
        }
    }

}
