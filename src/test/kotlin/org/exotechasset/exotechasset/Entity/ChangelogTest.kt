import kotlin.test.Test
import kotlin.test.assertEquals
import org.exotechasset.exotechasset.entity.Changelog

internal class ChangelogTest {
    @Test
    fun testGet() {
        val changelog = Changelog()
        changelog.add("Change 1")
        changelog.add("Change 2")
        changelog.add("Change 3")

        val actual = changelog.get()

        assertEquals("Change 1", actual.get(0))
        assertEquals("Change 2", actual.get(1))
        assertEquals("Change 3", actual.get(2))
    }
}
