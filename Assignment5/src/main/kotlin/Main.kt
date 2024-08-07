package org.example

fun main() {
    val intVerifier = IntegerVerifier()
    println(intVerifier.verify("0123"))

    val floatVerifier = FloatingVerifier()
    println(floatVerifier.verify("0.0"))

    val binaryVerifier = BinaryVerifier()
    println(binaryVerifier.verify("1001"))
    println(binaryVerifier.verify("100"))

    val emailVerifier = EmailVerifier()
    println(emailVerifier.verify("Yo.Gabba@Gabba.co"))
    println(emailVerifier.verify("Yo.Gabba@Gabba..co"))
}