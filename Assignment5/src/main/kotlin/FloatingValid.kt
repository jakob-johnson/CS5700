package org.example

class FloatingValid: Valid {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char !in "0123456789"){
            verifier.state = Invalid()
        }
    }
}