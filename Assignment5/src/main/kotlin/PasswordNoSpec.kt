package org.example

class PasswordNoSpec: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "!@#\$%&*") {
            verifier.state = PasswordLastSpec()
        }
    }
}