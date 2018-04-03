package lambda

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExtensionFunctions {
    data class Goblin(val healthPoints: Int, val maxDamage: Int)

    private val fred = Goblin(10, 10)

    @Test
    fun `should be add behaviour through "extension functions"`() {
        fun Goblin.shoot(otherArmourClass:Int): Int {
            return this.maxDamage / otherArmourClass
        }


        assert.that(fred.shoot(2), equalTo(5))
    }

    @Test
    fun `define a "hit" extension function to allow the Goblin to take damage`() {

//        assert.that(fred.hit(2), equalTo(8))
    }
}
