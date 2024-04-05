import org.exotechasset.exotechasset.entity.Filter
import org.exotechasset.exotechasset.usecase.FilterList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FilterListTest {
    @Test
    fun testFilterList() {
        val filterList = FilterList()

        assertEquals(0, filterList.size())
        assertEquals(emptyList<Filter>(), filterList.getAll())
    }
}
