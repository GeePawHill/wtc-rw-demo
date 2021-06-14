package org.geepawhill.rwu

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream

class Channel(socket: SocketWrapper, private val listener: Listener) : Talker, Runnable {
    private val input: BufferedReader = BufferedReader(
        InputStreamReader(
            socket.input
        )
    )
    private val output: PrintStream = PrintStream(socket.output, true)

    init {
        println("Channel: ${socket.machine}")
        listener.birth(this)
        println("Waiting for client...")
    }

    override fun run() {
        try {
            while (true) {
                val message = input.readLine()
                if (message != null) listener.hear(this, message)
                else break
            }
        } finally {
            closeQuietly()
        }
    }

    private fun closeQuietly() {
        try {
            listener.death(this)
            input.close()
            output.close()
        } catch (ex: IOException) {
        }
    }

    @Synchronized
    override fun say(message: String) {
        output.println(message)
    }
}