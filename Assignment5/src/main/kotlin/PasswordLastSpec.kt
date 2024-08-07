package org.example

class PasswordLastSpec: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char !in "!@#\$%&*") {
            verifier.state = PasswordValid()
        }
    }
}