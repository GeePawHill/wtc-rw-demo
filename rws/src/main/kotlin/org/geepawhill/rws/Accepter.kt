package org.geepawhill.rws

import java.io.IOException
import java.net.ServerSocket

class Accepter(private val port: Int, private val listener: Listener) : Runnable {
    override fun run() {
        val socket = ServerSocket(port)
        while (true) {
            try {
                val accepted = socket.accept()
                Thread(Channel(SocketWrapper(accepted), listener)).start()
            } catch (exception: IOException) {
                exception.printStackTrace();
            }
        }
    }
}