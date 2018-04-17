package functions

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecursiveFunctions {


    @Test
    fun `cannot recurse on a lambda`() {
        val ok = false
/*
        val def: () -> Unit = {
            if (ok) def()
        }
*/
    }

    @Test
    fun `can detect if functions are not tail recursive`() {
        tailrec fun fibonacci(n: Int): Int = when (n) {
            0, 1 -> n
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }

        assert.that(fibonacci(5), equalTo(5))
    }

    @Test
    fun `can optimize tail recursive functions`() {
        tailrec fun recsum(x: Int, running_total: Int = 0): Int = when(x) {
            0 -> running_total
            else -> recsum(x - 1, running_total + x)
        }

        assert.that(recsum(5), equalTo(15))
    }
}