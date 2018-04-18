package collections

import com.natpryce.hamkrest.anything
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MapTests {

    @Test
    fun `should be able to create using to syntax`() {
        val daysOfWeek = mapOf(
                "Monday" to "Mon",
                "Tuesday" to "Tue",
                "Wednesday" to "Wed",
                "Thursday" to "Thu",
                "Friday" to "Fri"
        )

        assertThat(daysOfWeek["Monday"], equalTo("Mon"))
    }

    @Test
    fun `should be an immutable map` () {
        val daysOfWeek = mapOf(
                "Monday" to "Mon",
                "Tuesday" to "Tue",
                "Wednesday" to "Wed",
                "Thursday" to "Thu",
                "Friday" to "Fri"
        )

        // daysOfWeek["Saturday"] = "Sat"
        assertThat(daysOfWeek["Saturday"], equalTo("Sat"))
    }

    @Test
    fun `should be able to use anything as keys`() {
        val test = mapOf(
                Person("male", "Bob") to "Bob",
                null to "",
                anything to "anything"
        )

        assertThat(test.keys.size, equalTo(3))
    }

    @Test
    fun `should support destructuring`() {
        val daysOfWeek = mapOf(
                "Monday" to "Mon",
                "Tuesday" to "Tue",
                "Wednesday" to "Wed",
                "Thursday" to "Thu",
                "Friday" to "Fri"
        )

        val list: List<String> = daysOfWeek.map { (_, value) -> value }
        val (head) = list
        assertThat(head, equalTo("Mon"))
    }
}
