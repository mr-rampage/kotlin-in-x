package basics

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TypesTest {

    @Test
    fun `should not contain primitives`() {
        val x: Int = 42
        val y: Int? = null
    }

    @Test
    fun `should be able to read nicely`() {
        val x: Int = 42_000_0000
        val butYouCanPutThemAnywhere: Int = 42_____000___0
    }

    @Test
    fun `should allow for implicit typing`() {
        val oddsForLeafsGoingToTheCup = 0.05
    }

    @Test
    fun `should allow for interesting names with backticks`() {
        val `use these carefully` = 100
        val `😺` = "Cats can be variables"
    }

    @Test
    fun `on the topic of strings`() {
        val height = 6
        val myHeight = "I am $height feet tall"
    }

}
