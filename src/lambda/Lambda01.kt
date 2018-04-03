package lambda

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

typealias Summable = (Int, Int) -> Int

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FunctionLiterals {

    @Test
    fun `can be defined as an "anonymous function"`() {
        val sum = fun(x: Int, y: Int): Int = x + y
        assert.that(sum(1, 1), equalTo(2))
    }

    @Test
    fun `define an "anonymous function" to multiply two integers`() {
//        assert.that(multiplyBy(2,3), equalTo(6))
    }

    @Test
    fun `can be defined as a "lambda expression"`() {
        val sum = { x: Int, y: Int -> x + y }
        assert.that(sum(1, 1), equalTo(2))
    }

    @Test
    fun `define a "lambda expression" to sum three integers`() {
//        assert.that(sum(1, 2, 3), equalTo(6))
    }

    @Test
    fun `can be typed`() {
        val sum: (Int, Int) -> Int = { x, y -> x + y }
        assert.that(sum(1, 1), equalTo(2))
    }

    @Test
    fun `can be called with receivers`() {
        val sum: Int.(Int) -> Int = { other -> plus(other) }
        assert.that(sum(1, 1), equalTo(2))
        assert.that(1.sum(1), equalTo(2))
    }

    @Test
    fun `define a "lambda expression" using receiver syntax`() {
        class Goblin(val healthPoints: Int) {
            fun hit(damage: Int): Int {
                return healthPoints - damage
            }
        }

//        val applyDamage
        val fred = Goblin(10)

//        assert.that(applyDamage(fred, 1), equalTo(9))
    }

    @Test
    fun `can reference receivers by this`() {
        val sum: Int.(Int) -> Int = { other -> this + other }
        assert.that(sum(1, 1), equalTo(2))
    }

    @Test
    fun `can be infixed when using receivers`() {
        infix fun Int.addedTo(x: Int): Int = this + x
        assert.that(1 addedTo 1 , equalTo(2))
    }

    @Test
    fun `can be type aliased`() {
        val sum: Summable = { x, y -> x + y }
        assert.that(sum(1, 1), equalTo(2))
    }
}