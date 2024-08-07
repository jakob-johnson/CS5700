package org.example

class PasswordNoCap: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        if (char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"){
            verifier.state = PasswordValid()
        }
    }
}