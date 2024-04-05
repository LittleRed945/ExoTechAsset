import org.exotechasset.exotechasset.entity.Location
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LocationTest {
    @Test
    fun testName() {
        val name = "Sample Location"
        val location = Location(name)

        assertEquals(name, location.get())
    }

    @Test
    fun testEmptyName() {
        val name = ""
        val location = Location(name)

        assertEquals(name, location.get())
    }

    @Test
    fun testLongName() {
        val name = "This is a very long location name"
        val location = Location(name)

        assertEquals(name, location.get())
    }
}
