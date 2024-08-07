package org.example

class Invalid: State {
    override fun consumeCharacter(char: String, verifier: Verifier) {
        print("In invalid state :o")
    }
}