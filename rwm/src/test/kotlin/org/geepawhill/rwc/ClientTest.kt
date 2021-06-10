package org.geepawhill.rwc

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class MakingTest {
    @Test
    fun testAppHasAGreeting() {
        val classUnderTest = Client()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}
