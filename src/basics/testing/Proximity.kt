package basics.testing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


class Proximity {
    fun subtract(x: Int, y: Int): Int {
        return x - y
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
private class EmbeddedTest {
    private val fixture = Proximity()

    @Test
    fun `Subtracting numbers should return the difference`() {
        assertEquals(0, fixture.subtract(5, 5))
    }
}
