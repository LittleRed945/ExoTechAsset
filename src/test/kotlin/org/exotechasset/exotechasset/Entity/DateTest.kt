import org.exotechasset.exotechasset.entity.Date
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal class DateTest {
    @Test
    fun testDate() {
        val timestamp: Long = 1714608000
        val expectedDate = "2024-05-02T00:00:00Z"
        val date = Date(timestamp)

        assertEquals(timestamp, date.get())
        assertEquals(expectedDate, date.toString())
    }

    @Test
    fun testOfNow() {
        val now = Instant.now().epochSecond
        val date = Date.ofNow()
        assertEquals(now, date.get())
    }

    @Test
    fun testToString() {
        val timestamp = 1678888888L
        val zone = ZoneOffset.ofHours(8)
        val date = Date(timestamp, zone)
        val expectedFormattedDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(timestamp), zone)
            .format(DateTimeFormatter.ISO_DATE_TIME)

        assertEquals(expectedFormattedDate, date.toString())
    }
}
