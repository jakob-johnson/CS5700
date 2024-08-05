package org.example

class Jump: InstructionsTemplate() {
    override fun incrementCounter(computer: Computer){}

    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.setP(byte1.toInt() and 0xF + byte2.toInt())
    }
}