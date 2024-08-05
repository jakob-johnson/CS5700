package org.example

class ConvertToBaseTen: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.convertBaseTen(byte1.toInt() and 0xF)
    }
}