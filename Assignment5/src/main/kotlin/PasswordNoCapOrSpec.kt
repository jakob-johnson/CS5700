package org.example

class PasswordNoCapOrSpec: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            verifier.state = PasswordNoSpec()
        } else if (char in "!@#\$%&*") {
            verifier.state = PasswordNoCap()
        }
    }
}