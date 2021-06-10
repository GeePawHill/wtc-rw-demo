package org.geepawhill.rwc

import tornadofx.View
import tornadofx.hbox
import tornadofx.label

class ClientView : View("Robot World Client") {
    override val root = hbox {
        minWidth = 400.0
        label("Hi Mom!")
    }
}