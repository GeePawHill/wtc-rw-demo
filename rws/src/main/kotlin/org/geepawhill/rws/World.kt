package org.geepawhill.rws

import org.geepawhill.rwu.Listener
import org.geepawhill.rwu.Talker

class World : Listener {
    override fun birth(talker: Talker) {
        println("Birth: $talker")
    }

    override fun death(talker: Talker) {
        println("Death: $talker")
    }

    override fun hear(talker: Talker, message: String) {
        println("$talker: $message")
    }
}