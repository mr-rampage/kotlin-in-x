package collections

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListsTest {

    @Test
    fun `should be immutable`() {
        val numbers: MutableList<Int> = mutableListOf(1,2,3)
        val immutableNumbers: List<Int> = numbers;

        numbers.add(4)

        assertThat(immutableNumbers.size, equalTo(3))
    }

    @Test
    fun `should be really immutable`() {
        val immutableNumbers: List<Int> = listOf(1,2,3);
        val numbers: MutableList<Int> = immutableNumbers.toMutableList()

        numbers.add(4)

        assertThat(immutableNumbers.size, equalTo(3))
    }

    @Test
    fun `should support high order functions`() {
        val numbers: List<Int> = listOf(1,2,3)

        assertThat(numbers.first(), equalTo(1))
        assertThat(numbers.last(), equalTo(3))
        assertThat(numbers.filter { it % 2 == 0}, equalTo(listOf(2)))
    }

    @Test
    fun `do mutable lists support high order functions?`() {
        val numbers: MutableList<Int> = mutableListOf(1,2,3)
    }

    @Test
    fun `what is the expected type of "test"?`() {
        val numbers: MutableList<Int> = mutableListOf(1,2,3)
        val test = numbers.requireNoNulls()
    }

    @Test
    fun `should allow lists to be covariant`() {
        val people: List<Person> = listOf(
                Person("male", "Avery"),
                Person("female", "Cary")
        )

        val humans: List<Human> = people

        assertThat(people, equalTo(humans))
    }

    @Test
    fun `but covariants still respect the interface`() {
        val people: List<Person> = listOf(
                Person("male", "Avery"),
                Person("female", "Cary")
        )

        val humans: List<Human> = people

        assertThat(people.get(0).gender, equalTo("male"))
        //assertThat(humans.get(0).name, equalTo("Avery"))
    }

    @Test
    fun `should be able to destructure a list` () {
        val people: List<Person> = listOf(
                Person("male", "Avery"),
                Person("female", "Cary"),
                Person("unknown", "Chewbacca")
        )

        val (avery) = people
        val (_, _, chewie) = people

        assertThat(avery, equalTo(people.get(0)))
        assertThat(chewie, equalTo(people.get(2)))
    }
}

open class Human (open val gender: String) {}

data class Person (override val gender: String, val name: String): Human(gender) {}
