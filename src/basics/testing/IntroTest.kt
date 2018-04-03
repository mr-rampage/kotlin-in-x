package basics.testing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntroTest {
    private val fixture: Intro = Intro()


    @Test
    fun addingNumbers_thenReturnSum() {
        assertEquals(10, fixture.add(5,5))
    }

    @Test
    fun `Adding numbers should return the sum`() {
        assertEquals(10, fixture.add(5,5))
    }
}