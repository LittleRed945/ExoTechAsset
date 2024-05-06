import org.exotechasset.exotechasset.entity.*
import org.exotechasset.exotechasset.usecase.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FilterChainTest {
    private val assetHandler = AssetHandler(listOf(Asset("AS-01"), Asset("AS-02"), Asset("AS-03")))

    //     @Test
    //     fun testFilterChain() {
    //         val filterChain = FilterChain(this.assetList)
    //         val filter = Filter("Category", "Electronics")
    //
    //         assertEquals(0, filterChain.size())
    //
    //         filterChain.addFilter(filter)
    //
    //         assertEquals(1, filterChain.size())
    //         assertEquals(emptyList<Filter>(), filterChain.getFilterList())
    //     }
    @Test
    fun testGetSize() {
        val filterChain = FilterChain(this.assetList)

        assertEquals(0, filterChain.size())
    }

    @Test
    fun testGetFilterList() {
        val filterChain = FilterChain(this.assetHandler)

        assertEquals(emptyList<Filter>(), filterChain.getFilterList())
    }

    @Test
    fun testAddFilter() {
        val filterChain = FilterChain(this.assetHandler)
        val filter = EqualsToFilter(FilterField.ID, "AS-01")

        filterChain.addFilter(filter)

        assertEquals(listOf(filter), filterChain.getFilterList())
    }

    @Test
    fun testFilter() {
        val assetList2 =
                listOf(
                        Asset("AS-01", auditDate = Date(1714402762)),
                        Asset("AS-02", auditDate = Date(1717171200)),
                        Asset("AS-03", auditDate = Date(1969632000))
                )

        val filterChain = FilterChain(AssetHandler(assetList2))

        filterChain.addFilter(GreaterThanFilter(FilterField.AUDIT_DATE, 1714402763.toLong()))
        filterChain.addFilter(LessThanFilter(FilterField.AUDIT_DATE, 1969631000.toLong()))

        assertEquals(1, filterChain.filterAsset().size())
        assertEquals(assetList2[1].getId(), filterChain.filterAsset().getChildren()[0].getId())
    }
}
