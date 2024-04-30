import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.usecase.AssetIterator
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AssetIteratorTest {
    @Test
    fun testAssetIterator() {
        val assets = listOf(Asset("Asset 1"), Asset("Asset 2"), Asset("Asset 3"))
        val assetList = AssetList(assets)
        val iterator = AssetIterator(assetList)

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(assets[0], iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(assets[1], iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(assets[2], iterator.getValue())

        assertEquals(false, iterator.hasNext())
    }
}
