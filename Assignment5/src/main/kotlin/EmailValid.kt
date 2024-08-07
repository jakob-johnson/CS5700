package org.example

class EmailValid: Valid {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in " @."){
            verifier.state = Invalid()
        }
    }
}