package org.example

class Jump: InstructionsTemplate() {
    override fun incrementCounter(computer: Computer){}

    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setP(((byte1.toInt() and 0xF).toString(16) +
                (byte2.toInt() shr 4).toString(16) +
                (byte2.toInt() and 0xF).toString(16)).toInt(16))
    }
}