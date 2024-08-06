package org.example

class SetT: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setT(((byte1.toInt() and 0XF).toString(16)
                + (byte2.toInt() shr 4).toString(16)).toInt(16))
    }
}