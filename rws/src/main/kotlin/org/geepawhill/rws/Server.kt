package org.geepawhill.rws

class Server {
}

fun main(args: Array<String>) {
    val world = World()
    val accepter = Accepter(1000, world)
    accepter.run()
}