package org.geepawhill.rws

interface Listener {
    fun birth(talker: Talker)
    fun death(talker: Talker)
    fun hear(talker: Talker, message: String)
}