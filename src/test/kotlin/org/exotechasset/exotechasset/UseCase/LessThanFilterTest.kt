import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Date
import org.exotechasset.exotechasset.entity.FilterField
import org.exotechasset.exotechasset.Usecase.LessThanFilter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LessThanFilterTest {
        private val assetList =
                        listOf(
                                        Asset("AS-01", auditDate = Date(1714402762)),
                                        Asset("AS-02", auditDate = Date(1717171200)),
                                        Asset("AS-03", auditDate = Date(1969632000))
                        )

        @Test
        fun testMeet() {
                val filter = LessThanFilter(FilterField.AUDIT_DATE, 1717171200.toLong())
                val filteredAssets = filter.meet(assetList)

                assertEquals(listOf(assetList[0]), filteredAssets)
        }
}
