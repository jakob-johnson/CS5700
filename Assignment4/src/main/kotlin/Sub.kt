package org.example

class Sub: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        val value1 = computer.getRegister(byte1.toInt() and 0xF)
        val value2 = computer.getRegister(byte2.toInt() shr 4)

        computer.modifyRegister(byte2.toInt() and 0xF, (value1 - value2).toUByte())
    }
}