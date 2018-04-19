package basics

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControlFlowTests {
    @Test
    fun `should treat conditionals as expressions` () {
        val condition = true

        assertThat(if (condition) 5 else 3, equalTo(5))
    }

    @Test
    fun `should return the last value of a block` () {
        val condition = true

        assertThat(if (condition) {
            5
            6
            7
        } else {
            3
        },
        equalTo(7))
    }

    @Test
    fun `should use when statements as switch operators` () {
        val x = 100

        val y = when (x) {
            0, 1 -> "it's 0 or 1"
            in 1..Int.MAX_VALUE -> "it's greater than 1"
            else -> "less than 0"
        }

        val z = when {
            x < 0 -> "less than 0"
            x == 0 || x == 1 -> "it's 0 or 1"
            x > 1 -> "it's greater than 1"
            else -> "Unsure??? It's got to be exhaustive"
        }
    }

    @Test
    fun `interesting because one can do pattern matching similar to scala`() {
        fun patternMatch(x: Any) = when(x) {
            is String -> "I am a string"
            is Int -> "I am an integer"
            else -> "I am anything else"
        }

        assertThat(patternMatch("a string"), equalTo("I am a string"))
        assertThat(patternMatch(100), equalTo("I am an integer"))
    }
}
