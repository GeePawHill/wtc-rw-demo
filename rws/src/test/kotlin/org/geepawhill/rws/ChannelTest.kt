package org.geepawhill.rws

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class ChannelTest {
    private val INPUT_STRING = "This is a string"

    // For all tests, The input has one line, read during the run() call.
    // the second time through the loop in run(), it will reach EOF, which is the same as if the 
    // socket were closed
    
    private val inputStream = INPUT_STRING.byteInputStream()
    private val outputStream = ByteArrayOutputStream()
    private val socket = SocketWrapper(inputStream, outputStream, "TEST")
    private val listener = TestingListener()

    @Test
    fun `gives birth message`() {
        val channel = Channel(socket, listener)
        assertThat(listener.talkers).containsExactly(channel)
    }

    @Test
    fun `passes message on`() {
        val channel = Channel(socket, listener)
        channel.run()
        assertThat(listener.messages).containsExactly(ReceivedSay(channel, INPUT_STRING))
    }

    @Test
    fun `dies on eof`() {
        val channel = Channel(socket, listener)
        channel.run()
        assertThat(listener.talkers).isEmpty()
    }

    @Test
    fun `says to output`() {
        val channel = Channel(socket, listener)
        channel.say("Hi mom!")
        channel.run()
        assertThat(outputStream.toByteArray()).isEqualTo("Hi mom!\r\n".toByteArray())
    }
}