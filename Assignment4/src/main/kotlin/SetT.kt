package org.example

class SetT: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setT(byte1.toInt() and 0XF + byte2.toInt() shr 4)
    }
}