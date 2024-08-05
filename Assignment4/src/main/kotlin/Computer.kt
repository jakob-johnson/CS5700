package org.example

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Computer {
    private val executor = Executors.newSingleThreadScheduledExecutor()

    private var timerRunning = false

    private val timerFuture = executor.scheduleAtFixedRate({
        if (timerRunning){ updateTime() } },
        0,
        16,
        TimeUnit.MILLISECONDS
        )

    private var cpuRunning = false

    private val cpuFuture = executor.scheduleAtFixedRate({
        if (cpuRunning) {
            val byte1 = rom.read(cpu.p.toInt())
            val byte2 = rom.read(cpu.p.toInt() + 1)
            if (byte1.toInt() == 0 && byte2.toInt() == 0) {
                stopCpu()
            }

            }
        },
        0,
        2,
        TimeUnit.MILLISECONDS
        )



    private val rom = ROM()
    private val ram = RAM()
    private val cpu = CPU()
    private val screen = Screen()

    private fun updateTime(){
        if (cpu.t > 0u){
            cpu.setT((cpu.t - 1u).toUByte())
        }
    }

    private fun startTimer(){
        timerRunning = true
    }

    private fun stopTimer(){
        timerRunning = false
    }

    fun startCpu(){
        cpuRunning = true
    }

    fun stopCpu(){
        cpuRunning = false
    }

    fun incrementCounter(){
        cpu.setP((cpu.p + 2u).toUShort())
    }

    fun modifyRegister(pos: Int, value: UByte){
        cpu.updateRegister(pos, value)
    }

    fun getRegister(pos: Int): UByte {
        return cpu.registers[pos]
    }

    fun read(pos: Int){
        val data: UByte = if (cpu.m){
            rom.read((cpu.a.toInt()))
        } else {
            ram.read(cpu.a.toInt())
        }

        modifyRegister(pos, data)
    }

    fun write(pos: Int){
        val data = getRegister(pos)

        if (cpu.m){
            rom.write(cpu.a.toInt(), data)
        } else{
            ram.write(cpu.a.toInt(), data)
        }
    }

    fun setP(value: Int){
        if (value % 2 == 0){
            cpu.setP(value.toUShort())
        } else{
            throw IllegalArgumentException("P needs to be even")
        }
    }

    fun setM(){
        cpu.setM(!cpu.m)
    }

    fun getP(): UShort{
       return cpu.p
    }

    fun setA(value: Int){
        cpu.setA(value.toUShort())
    }

    fun setT(value: Int){
        cpu.setT(value.toUByte())
    }

    fun getT(): UByte {
        return cpu.t
    }

    fun convertBaseTen(value: Int) {
        val data = getRegister(value)

        val ones = data.rem(10u)
        val tens = data.div(10u).rem(10u)
        val hundreds = data.div(100u)

        if (cpu.m){
            rom.write(cpu.a.toInt() + 2, ones.toUByte())
            rom.write(cpu.a.toInt() + 1, tens.toUByte())
            rom.write(cpu.a.toInt(), hundreds.toUByte())
        } else {
            ram.write(cpu.a.toInt() + 2, ones.toUByte())
            ram.write(cpu.a.toInt() + 1, tens.toUByte())
            ram.write(cpu.a.toInt(), hundreds.toUByte())
        }
    }

    fun draw(position: Int, x: Int, y: Int){
         val value = getRegister(position)

        ram.write(x * 8 + y, value)

        screen.draw(x, y, value)
    }

}