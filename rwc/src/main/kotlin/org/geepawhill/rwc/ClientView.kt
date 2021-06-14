package org.geepawhill.rwc

import javafx.beans.property.SimpleStringProperty
import org.geepawhill.rwu.Channel
import org.geepawhill.rwu.Listener
import org.geepawhill.rwu.SocketWrapper
import org.geepawhill.rwu.Talker
import tornadofx.*
import java.net.Socket

class ClientView : View("Robot World Client"), Listener {
    private val channel: Channel
    private val youSaid = SimpleStringProperty()
    private val lastResponse = SimpleStringProperty()
    override val root = form {
        minWidth = 400.0
        fieldset {
            field("You say") {
                textfield(youSaid)
            }
            field("Server says") {
                label(lastResponse)
            }
            button("Say") {
                action {
                    sayArbitrary()
                }
            }
        }
    }

    init {
        val socket = Socket("localhost", 1000)
        channel = Channel(SocketWrapper(socket), this)
        Thread(channel).start()
    }

    fun sayArbitrary() {
        channel.say(youSaid.value)
    }

    override fun birth(talker: Talker) {
    }

    override fun death(talker: Talker) {
    }

    override fun hear(talker: Talker, message: String) {
        runLater {
            lastResponse.value = message
        }
    }
}