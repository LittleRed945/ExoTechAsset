import org.exotechasset.exotechasset.entity.*
import org.exotechasset.exotechasset.Usecase.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FilterListTest {
    private val assetHandler = AssetHandler(listOf(Asset("AS-01"), Asset("AS-02"), Asset("AS-03")))

    //     @Test
    //     fun testFilterList() {
    //         val filterList = FilterList(this.assetList)
    //         val filter = Filter("Category", "Electronics")
    //
    //         assertEquals(0, filterList.size())
    //
    //         filterList.addFilter(filter)
    //
    //         assertEquals(1, filterList.size())
    //         assertEquals(emptyList<Filter>(), filterList.getFilterList())
    //     }
    @Test
    fun testGetSize() {
        val filterList = FilterList(this.assetHandler)

        assertEquals(0, filterList.size())
    }

    @Test
    fun testGetFilterList() {
        val filterList = FilterList(this.assetHandler)

        assertEquals(emptyList<Filter>(), filterList.getFilterList())
    }

    @Test
    fun testAddFilter() {
        val filterList = FilterList(this.assetHandler)
        val filter = EqualsToFilter(FilterField.ID, "AS-01")

        filterList.addFilter(filter)

        assertEquals(listOf(filter), filterList.getFilterList())
    }

    @Test
    fun testFilter() {
        val assetList2 =
                listOf(
                        Asset("AS-01", auditDate = Date(1714402762)),
                        Asset("AS-02", auditDate = Date(1717171200)),
                        Asset("AS-03", auditDate = Date(1969632000))
                )

        val filterList = FilterList(AssetHandler(assetList2))

        filterList.addFilter(GreaterThanFilter(FilterField.AUDIT_DATE, 1714402763.toLong()))
        filterList.addFilter(LessThanFilter(FilterField.AUDIT_DATE, 1969631000.toLong()))

        assertEquals(1, filterList.filterAsset().size())
        assertEquals(assetList2[1].getId(), filterList.filterAsset().getChildren()[0].getId())
    }
}
