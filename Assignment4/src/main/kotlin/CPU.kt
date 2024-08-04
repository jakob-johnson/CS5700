package org.example

class CPU {
    var p: UShort = 0u
        private set

    var t: UByte = 0u
        private set

    var a: UShort = 0u
        private set

    var m: Boolean = false
        private set

    val registers: MutableList<UByte> = MutableList(8) {0u}

    fun setP(value: UShort){
        p = value
    }

    fun setT(value: UByte){
        t = value
    }

    fun setA(value: UShort){
        a = value
    }

    fun setM(value: Boolean){
        m = value
    }

    fun updateRegister(pos: Int, value: UByte){
        registers[pos] = value
    }
}