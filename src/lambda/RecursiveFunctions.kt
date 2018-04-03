package lambda

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
    fun `can optimize using tail recursion`() {
        tailrec fun fibonacci(n: Int): Int = when (n) {
            0, 1 -> n
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }

        assert.that(fibonacci(5), equalTo(5))
    }
}