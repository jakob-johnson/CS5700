package org.example

fun main() {
    val intVerifier = IntegerVerifier()
    println(intVerifier.verify("0123"))

    val floatVerifier = FloatingVerifier()
    println(floatVerifier.verify("0.0"))

}