package org.example

class SkipNotEqual: InstructionsTemplate() {
   override fun performOperation(byte1: UByte, byte2: UByte, computer: Computer) {
       if (computer.getRegister(byte1.toInt() and 0xF) != computer.getRegister(byte2.toInt() shr 4)){
           computer.setP((computer.getP() + 2u).toInt())
       }
   }
}