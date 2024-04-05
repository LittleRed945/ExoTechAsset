import kotlin.test.Test
import kotlin.test.assertEquals
import org.exotechasset.exotechasset.entity.AssetDescription

internal class AssetDescriptionTest {
    private val assetDescription: AssetDescription = AssetDescription("Sample description")

    @Test
    fun testGetDescription() {
        val expectedDescription = "Sample description"
        val actualDescription = assetDescription.getDescription()
        assertEquals(expectedDescription, actualDescription)
    }
}
