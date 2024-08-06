package org.example

class SetA: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setA((((byte1.toInt() and 0xF).toString(16)
                + (byte2.toInt() shr 4).toString(16)
                + (byte2.toInt() and 0xF).toString(16)).toInt(16)))
    }
}