package org.example

class ReadKeyboard: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        computer.pauseCpu()

        println("Please use keyboard for input...")

        var input = readlnOrNull()

        if (input.isNullOrEmpty()){
            input = 0u.toString()
        }

        input = input.take(2)
        val hex = input.toIntOrNull(16)
        if (hex != null && hex in 0..255){
            computer.modifyRegister(byte1.toInt() and 0xF, hex.toUByte())
        } else{
            println("Invalid input")
        }
        computer.startCpu()
        }


}