import org.exotechasset.exotechasset.entity.Asset
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
}
