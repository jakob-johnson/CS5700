package org.example

class SwitchMemory: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setM()
    }
}