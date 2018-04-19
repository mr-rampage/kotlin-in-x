package basics

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

// Classes that only hold data
data class Awesome(val x: Int, val y: Int, val z: Int)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataClassesTest {
    val somePoint = Awesome( 1,2,3)

    @Test
    fun `Data classes support destructuring` () {
        val (x, y, z) = somePoint
        val (a, b, c) = somePoint

        assertThat(a, equalTo(x))
    }
}

