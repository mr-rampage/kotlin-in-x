package functions

import collections.Person
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LambdaParameters {

    @Test
    fun `can be defined without parameters`() {
        val five: () -> Int = { 5 }
        assert.that(five(), equalTo(5))
    }

    @Test
    @Disabled
    fun `should not mutate parameter values`() {
        var mutable: Int = 0;
        //val makeFive: (Int) -> Unit = { x -> x = 5 }
        val makeFive: (Int) -> Unit = { x -> x }
        makeFive(mutable);
        assert.that(mutable, equalTo(5))
    }


    @Test
    fun `should declare the first parameter implicitly with it`() {
        val increment: (Int) -> Int = { it + 1 }
        assertEquals(2, increment(1))
        assert.that(increment(1), equalTo(2))
    }

    @Test
    fun `should create higher-order functions by passing in behaviour`() {
        val transformer: (Int, (Int) -> Int) -> Int = { value, transform -> transform(value) }
        assert.that(transformer(2, { x -> x * 2 }), equalTo(4))
    }

    @Test
    fun `should pass lambda outside of function call if it is the last argument`() {
        val transformer: (Int, (Int) -> Int) -> Int = { value, transform -> transform(value) }
        assert.that(transformer(2) {
            x -> x * 2
        }, equalTo(4))
    }

    @Test
    fun `should pass lambda as a reference`() {
        val transformer: (Int, (Int) -> Int) -> Int = { value, transform -> transform(value) }
        val timesTwoLambda: (Int) -> Int = { it * 2}

        assert.that(transformer(2, timesTwoLambda), equalTo(4))
    }

    @Test
    fun `should pass functions as a reference with two colons`() {
        val transformer: (Int, (Int) -> Int) -> Int = { value, transform -> transform(value) }

        fun timesTwoFunction(x: Int): Int {
            return x * 2
        }

        assert.that(transformer(2, ::timesTwoFunction), equalTo(4))

    }

    @Test
    fun `should be able to destructure a parameter` () {
        val fred = Person("male", "Fred Flintstone")
        val greeting: (Person) -> String = { (gender, name) -> "Hello, $gender human $name" }

        assert.that(greeting(fred), equalTo("Hello, male human Fred Flintstone"))
    }

    @Test
    fun `but what do you think happens here?` () {
        val fred = Person("male", "Fred Flintstone")
        val greeting: (Person) -> String = { (name, gender) -> "Hello, $gender human $name" }

        assert.that(greeting(fred), equalTo("Hello, male human Fred Flintstone"), { "Javascript destructuring is superior"})
    }
}