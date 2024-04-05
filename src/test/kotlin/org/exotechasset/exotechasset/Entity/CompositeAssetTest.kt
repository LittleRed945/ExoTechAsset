import org.exotechasset.exotechasset.entity.AssetStatus
import org.exotechasset.exotechasset.entity.CompositeAsset
import org.exotechasset.exotechasset.entity.Date
import org.exotechasset.exotechasset.entity.Location
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CompositeAssetTest {
    @Test
    fun testConstructor() {
        val id = "123"
        val status = AssetStatus.DEPLOYABLE
        val assignee = "John Doe"
        val auditDate = Date(1714608000)
        val location = Location("Room 1623")

        val asset = CompositeAsset(id, status, assignee, auditDate, location)

        assertEquals(id, asset.getId())
        assertEquals(status, asset.getStatus())
        assertEquals(assignee, asset.getAssignee())
        assertEquals(auditDate, asset.getAuditDate())
        assertEquals(location, asset.getLocation())
    }
}
