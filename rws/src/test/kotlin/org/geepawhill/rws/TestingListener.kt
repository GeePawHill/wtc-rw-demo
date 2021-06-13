package org.geepawhill.rws

data class ReceivedSay(val talker: Talker, val message: String)

class TestingListener : Listener {
    val messages = mutableListOf<ReceivedSay>()
    val talkers = mutableSetOf<Talker>()

    override fun birth(talker: Talker) {
        talkers.add(talker)
    }

    override fun death(talker: Talker) {
        talkers.remove(talker)
    }
    
    override fun hear(talker: Talker, message: String) {
        messages.add(ReceivedSay(talker, message))
    }

}