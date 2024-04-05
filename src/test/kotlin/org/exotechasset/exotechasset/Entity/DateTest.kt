import org.exotechasset.exotechasset.entity.Date
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DateTest {
    @Test
    fun testDate() {
        val timestamp: Long = 1714608000
        val expectedDate = "2024-05-02T00:00:00Z"
        val date = Date(timestamp)

        assertEquals(timestamp, date.get())
        assertEquals(expectedDate, date.toString())
    }
}
