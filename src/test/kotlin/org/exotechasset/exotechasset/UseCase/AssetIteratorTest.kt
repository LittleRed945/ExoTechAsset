import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.usecase.AssetIterator
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Assertions.*
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


    @Test
    fun testNext() {
        val asset1 = Asset(id = "asset1")
        val asset2 = Asset(id = "asset2")
        val assetList = AssetList(listOf(asset1, asset2))
        val assetIterator = AssetIterator(assetList)

        assetIterator.next()
        assertEquals(asset1, assetIterator.getValue())

        assetIterator.next()
        assertEquals(asset2, assetIterator.getValue())
    }

    @Test
    fun testHasNext() {
        val asset1 = Asset(id = "asset1")
        val assetList = AssetList(listOf(asset1))
        val assetIterator = AssetIterator(assetList)

        assertTrue(assetIterator.hasNext())

        assetIterator.next()
        assertFalse(assetIterator.hasNext())
    }

    @Test
    fun `test getValue`() {
        val asset1 = Asset(id = "asset1")
        val assetList = AssetList(listOf(asset1))
        val assetIterator = AssetIterator(assetList)

        assetIterator.next()
        assertEquals(asset1, assetIterator.getValue())
    }
}
