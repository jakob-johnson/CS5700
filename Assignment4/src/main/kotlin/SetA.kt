package org.example

class SetA: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
       computer.setA(byte1.toInt() and 0xF + byte2.toInt())
    }
}