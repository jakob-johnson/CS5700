package org.example

class Write: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.write(byte1.toInt() and 0xF)
    }
}