package basics

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClassesTest {
    @Test
    fun `should inherit`() {
        val bob: Person = Person("Human", "Bob")
        val covariantBob: Mammal = bob

        bob.name
        //covariantBob.name

        bob pay 5
    }
}

// final by default, private members by default
class Human(age: Int)

// to make it not final
open class Mammal(open val type: String = "Human")

class Person(override val type: String, val name: String) : Mammal(type) {
    var salary: Int = 0

    // Dragons be here
    var age: Int

    get() {
        return age * 2
    }

    set(value) {
        this.age = value / 2
    }

    init {
        this.age = 15
    }

    fun greet(): String {
        return "Hello, my name is $name"
    }

    infix fun pay(salary: Int): String {
        this.salary = salary
        return "Awesome"
    }
}



