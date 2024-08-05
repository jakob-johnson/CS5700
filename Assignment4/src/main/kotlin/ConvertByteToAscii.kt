package org.example

class ConvertByteToAscii: InstructionsTemplate() {
    override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
        var data = computer.getRegister(byte1.toInt() and 0xF).toInt()

        if (data > 15){
            throw IllegalArgumentException("Value is greater than limit for ASCII")
        }

        data += if (data < 10){
            48
        } else {
            55
        }

        computer.modifyRegister(byte2.toInt() shr 4, data.toUByte())

    }
}