package org.example

class Store: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.modifyRegister(byte1.toInt(), byte2)
    }
}