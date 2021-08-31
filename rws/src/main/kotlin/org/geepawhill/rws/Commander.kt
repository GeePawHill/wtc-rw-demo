package org.geepawhill.rws

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Commander {
    fun receive(message: String): Command {
        try {
            val attempt = Json.decodeFromString<JsonCommand>(message)
            return when (attempt.command) {
                "launch" -> LaunchCommand()
                else -> UnknownCommand()
            }
        } catch (e: Exception) {
            return IllFormedCommand()
        }
        return UnknownCommand()
    }
}
