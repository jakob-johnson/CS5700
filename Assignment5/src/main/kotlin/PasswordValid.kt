package org.example

class PasswordValid: Valid {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "!@#\$%&*") {
            verifier.state = PasswordLastSpec()
        }
    }
}