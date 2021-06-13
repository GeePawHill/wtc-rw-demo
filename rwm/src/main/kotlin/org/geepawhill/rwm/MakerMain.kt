package org.geepawhill.rwm

import org.geepawhill.rwc.Client
import tornadofx.App
import tornadofx.launch

class MakerMain : App(MakerView::class)

fun main() {
    val client = Client()
    launch<MakerMain>()
}