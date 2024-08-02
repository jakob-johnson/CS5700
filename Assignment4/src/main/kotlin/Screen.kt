package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class Screen {
    private val content = UByteArray(64)

    fun draw(row: Int, col: Int, value: UByte){
        content[row * 8 + col] = value
        display()
    }

    private fun display(){
        println("========")
        var counter = 0
        for (item in content){
            print(item.toInt().toChar())
            counter++
            if (counter == 8) {
                counter = 0
                println()
            }
        }
    }
}