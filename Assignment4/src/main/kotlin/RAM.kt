package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class RAM {
    private val memory = UByteArray(4096)

    fun write(index: Int, value: UByte){
        memory[index] = value
    }

    fun read(index: Int): UByte{
       return memory[index]
    }
}