package org.geepawhill.rws

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Commander {
    fun receive(message: String): Command {
        try {
            val attempt = Json.decodeFromString<JsonCommand>(message)
            if (attempt.command != "launch") return UnknownCommand()
        } catch (e: Exception) {
            return IllFormedCommand()
        }
        return UnknownCommand()
    }
}
