package org.example

class ReadT: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        val t = computer.getT()

        computer.modifyRegister(byte1.toInt() and 0xF, t)
    }
}