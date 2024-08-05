package org.example

class Read: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.read(byte1.toInt() and 0xF)
    }
}