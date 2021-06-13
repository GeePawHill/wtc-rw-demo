package org.geepawhill.rws

import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

class SocketWrapper(val input: InputStream, val output: OutputStream, val machine: String) {
    constructor(socket: Socket) : this(socket.getInputStream(), socket.getOutputStream(), socket.inetAddress.toString())
}