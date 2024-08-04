package org.example

abstract class InstructionsTemplate {
    fun executeInstruction(byte1: UByte, byte2: UByte, computer: Computer){
        performOperation(byte1, byte2, computer)
        incrementCounter(computer)
    }
    abstract fun performOperation(byte1: UByte, byte2: UByte, computer: Computer)

    open fun incrementCounter(computer: Computer){
        computer.incrementCounter()
    }
}