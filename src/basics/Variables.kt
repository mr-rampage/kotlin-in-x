package basics

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VariablesTest {

    @Test
    fun `should talk about nothing` () {
        val x: Nothing? = null
    }

    @Test
    fun `should consider immutability as first class `() {
        val x: Int = 5
    }

    @Test
    fun `should default to not nullable`() {
        val notNullable: Int = 5
        val nullable: Int? = null
    }

    @Test
    fun `but you can declare mutable variables`() {
        var mutable: Int = 5

        mutable = 10

        assertThat(mutable, equalTo(10))
    }

}
