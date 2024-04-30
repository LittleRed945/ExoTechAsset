import kotlin.test.Test
import kotlin.test.assertEquals
import org.exotechasset.exotechasset.entity.AssetStatus

internal class AssetStatusTest {
    private val status: AssetStatus = AssetStatus.PENDING

    @Test
    fun testToString() {
        assertEquals("Pending", this.status.toString())
    }
}
