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

    private fun startCpu(){
        cpuRunning = true
    }

    private fun stopCpu(){
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

}