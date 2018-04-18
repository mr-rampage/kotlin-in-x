package sequences

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SequenceTests {

    @Test
    fun `should be lazy`() {
        val stream = sequenceOf(1, 2)
        val mapped = stream.map { it * 2 }

        assertThat(mapped is Sequence, equalTo(true))

        assertThat(mapped.sum(), equalTo(6))
    }

    @Test
    fun `compared to iterable`() {
        val iter = listOf(1, 2)
        val mapped = iter.map { it * 2 }

        assertThat(mapped is List, equalTo(true))
    }

    @Test
    fun `should support infinite collections`() {
        val doubler = generateSequence(1, {
            it * 2
        })

        assertThat(
                doubler.take(10).toList(),
                equalTo(listOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512)))
    }

    @Test
    fun `how would you create the following sequence?` () {
       /*
        * Given a seed of 1
        * The next number would be 11
        * The following number would be 121
        * The following number would be 13231
        */
    }
}
