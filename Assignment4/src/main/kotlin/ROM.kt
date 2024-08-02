package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class ROM {
    private val memory = UByteArray(4096)

    fun load(newMemory: UByteArray){
        for ((pos, byte) in newMemory.withIndex()){
            memory[pos] = byte
        }
    }

    fun write(index: Int, value: UByte){
        memory[index] = value
    }

    fun read(index: Int): UByte{
        return memory[index]
    }
}