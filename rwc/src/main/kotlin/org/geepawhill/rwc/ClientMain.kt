package org.geepawhill.rwc

import tornadofx.App
import tornadofx.launch

class ClientMain : App(ClientView::class)

fun main() {
    launch<ClientMain>()
}