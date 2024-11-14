import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Date
import org.exotechasset.exotechasset.entity.FilterField
import org.exotechasset.exotechasset.Usecase.GreaterThanFilter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GreaterThanFilterTest {
    private val assetList =
            listOf(
                    Asset("AS-01", auditDate = Date(1714402762)),
                    Asset("AS-02", auditDate = Date(1717171200)),
                    Asset("AS-03", auditDate = Date(1969632000))
            )

    @Test
    fun testMeet() {

        val filter = GreaterThanFilter(FilterField.AUDIT_DATE, 1714406400.toLong())
        val filteredAssets = filter.meet(assetList)

        assertEquals(2, filteredAssets.size)
        assertEquals(listOf(assetList[1], assetList[2]), filteredAssets)
    }
}
