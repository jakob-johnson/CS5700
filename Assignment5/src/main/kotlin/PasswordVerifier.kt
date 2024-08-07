package org.example

class PasswordVerifier: Verifier {
    override var state: State = PasswordNoCapOrSpec()

    override fun verify(string: String): Boolean {
        state = PasswordNoCapOrSpec()
        if (string.length < 8) return false
        return super.verify(string)
    }
}