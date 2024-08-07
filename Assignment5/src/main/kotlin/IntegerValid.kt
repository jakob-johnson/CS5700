package org.example

class IntegerValid: Valid {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char !in "1234567890"){
            verifier.state = Invalid()
        }
    }
}