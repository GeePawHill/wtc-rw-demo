package org.geepawhill.rws

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommanderTest {

    val commander = Commander()

    @Test
    fun `empty string is IllFormedCommand`() {
        assertThat(commander.receive("")).isExactlyInstanceOf(IllFormedCommand::class.java)
    }

    @Test
    fun `garbage string is IllFormedCommand`() {
        assertThat(commander.receive("abcxyz")).isExactlyInstanceOf(IllFormedCommand::class.java)
    }

    @Test
    fun `well-formed unknown command is UnknownCommand`() {
        val input = Json.encodeToString(JsonCommand("", "garbage command"))
        assertThat(commander.receive(input)).isExactlyInstanceOf(UnknownCommand::class.java)
    }

    @Test
    fun `launch command is LaunchCommand`() {
        val input = Json.encodeToString(JsonCommand("", "launch"))
        assertThat(commander.receive(input)).isExactlyInstanceOf(LaunchCommand::class.java)
    }
}