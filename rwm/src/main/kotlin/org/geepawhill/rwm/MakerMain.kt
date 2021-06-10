package org.geepawhill.rwm

import org.geepawhill.rwc.Client
import org.geepawhill.rws.Server
import tornadofx.App
import tornadofx.launch

class MakerMain : App(MakerView::class)

fun main() {
    val client = Client()
    val server = Server()
    launch<MakerMain>()
}