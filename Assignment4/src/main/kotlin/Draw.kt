package org.example

class Draw: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.draw(byte1.toInt() and 0xF, byte2.toInt() shr 4, byte2.toInt() and 0xF)
    }
}