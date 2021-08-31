package org.geepawhill.rws

import kotlinx.serialization.Serializable

@Serializable
class JsonCommand(val robot: String, val command: String) {
}