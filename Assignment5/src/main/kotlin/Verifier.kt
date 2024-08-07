package org.example

interface Verifier {
    var state: State

    fun verify(string: String): Boolean {
        string.chunked(1).forEach {
            state.consumeCharacter(it, this)
        }
        return state is Valid
    }
}