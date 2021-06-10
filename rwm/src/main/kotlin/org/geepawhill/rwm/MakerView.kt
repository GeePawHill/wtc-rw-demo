package org.geepawhill.rwm

import tornadofx.View
import tornadofx.hbox
import tornadofx.label

class MakerView : View("Robot World Maker") {
    override val root = hbox {
        minWidth = 400.0
        label("Hi Mom!")
    }
}