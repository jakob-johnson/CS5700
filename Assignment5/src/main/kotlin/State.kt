package org.example

interface State {
    fun consumeCharacter(char: String, verifier: Verifier)
}