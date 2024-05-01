import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.AssetStatus
import org.exotechasset.exotechasset.entity.Date
import org.exotechasset.exotechasset.entity.Location
import org.exotechasset.exotechasset.usecase.FilterParameter
import org.exotechasset.exotechasset.usecase.FilterParameterBy as By
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FilterParameterTest {
    private val asset = Asset("AS-01")

    @Test
    fun testGet() {
        val filterParameter = FilterParameter(By.ID, null)
        assertEquals("AS-01", filterParameter.get(asset))
    }

    @Test
    fun testGetWithValue() {
        val asset = Asset(
            id = "asset1",
            status = AssetStatus.UNDEPLOYABLE,
            assignee = "John Doe",
            auditDate = Date.ofNow(),
            location = Location("1623")
        )

        val filterParameter = FilterParameter(By.VALUE, "Sample Value")
        assertEquals("Sample Value", filterParameter.get(asset))
    }

    @Test
    fun `testGetWithId`() {
        val asset = Asset(id = "asset1")
        val filterParameter = FilterParameter(By.ID, null)
        assertEquals("asset1", filterParameter.get(asset))
    }

    @Test
    fun `testGetWithStatus`() {
        val asset = Asset(id = "AS-01", status = AssetStatus.UNDEPLOYABLE)
        val filterParameter = FilterParameter(By.STATUS, null)
        assertEquals(AssetStatus.UNDEPLOYABLE, filterParameter.get(asset))
    }

    @Test
    fun `testGetWithAssignee`() {
        val asset = Asset(id = "AS-01", assignee = "Alice")
        val filterParameter = FilterParameter(By.ASSIGNEE, null)
        assertEquals("Alice", filterParameter.get(asset))
    }

    //@Test
//    fun `testGetWithAuditDate`() {
//        val auditDate = Date.ofNow()
//        val asset = Asset(id = "AS-01", auditDate = auditDate)
//        val filterParameter = FilterParameter(By.AUDIT_DATE, null)
//        assertEquals(auditDate.toString(), filterParameter.get(asset))
//    }

    @Test
    fun `testGetWithLocation`() {
        val location = Location("1623")
        val asset = Asset(id = "AS-01", location = location)
        val filterParameter = FilterParameter(By.LOCATION, null)
        assertEquals(location, filterParameter.get(asset))
    }

    @Test
    fun `testToNumberWithAuditDate`() {
        val auditDate = Date.ofNow()
        val asset = Asset(id = "AS-01", auditDate = auditDate)
        val filterParameter = FilterParameter(By.AUDIT_DATE, null)
        assertEquals(auditDate.get(),filterParameter.toNumber(asset))
    }

    @Test
    fun `testToStringWithStatus`() {
        val auditDate = Date.ofNow()
        val asset = Asset(id = "AS-01", status = AssetStatus.UNDEPLOYABLE)
        val filterParameter = FilterParameter(By.STATUS, null)

        assertEquals("Undeployable",filterParameter.toString(asset))
    }
}
