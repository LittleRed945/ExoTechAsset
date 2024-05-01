import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.CompositeAsset
import org.exotechasset.exotechasset.usecase.AssetIteratorFactory
import org.exotechasset.exotechasset.usecase.AssetIteratorType
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AssetIteratorFactoryTest {
    @Test
    fun testCreateAssetHierarchyIterator() {
        // Create a sample asset hierarchy
        val asset1 = CompositeAsset("AS-01")
        val asset2 = CompositeAsset("AS-02")
        val asset3 = CompositeAsset("AS-03")
        val asset4 = Asset("AS-04")
        val asset5 = Asset("AS-05")
        val asset6 = Asset("AS-06")
        val asset7 = Asset("AS-07")

        asset1.addChild(asset2)
        asset1.addChild(asset3)
        asset2.addChild(asset4)
        asset2.addChild(asset5)
        asset3.addChild(asset6)

        val assetList = AssetList(listOf(asset1, asset7))

        // Create an AssetHierarchyIterator
        val iterator = AssetIteratorFactory(assetList).create()

        // Test the iterator
        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset1, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset2, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset4, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset5, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset3, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset6, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset7, iterator.getValue())

        assertEquals(false, iterator.hasNext())
    }

    @Test
    fun testCreateAssetSimpleIterator() {
        // Create a sample asset hierarchy
        val asset1 = CompositeAsset("AS-01")
        val asset2 = CompositeAsset("AS-02")
        val asset3 = CompositeAsset("AS-03")
        val asset4 = Asset("AS-04")
        val asset5 = Asset("AS-05")
        val asset6 = Asset("AS-06")
        val asset7 = CompositeAsset("AS-07")

        asset1.addChild(asset2)
        asset1.addChild(asset3)
        asset2.addChild(asset4)
        asset2.addChild(asset5)
        asset3.addChild(asset6)

        val assetList = AssetList(listOf(asset1, asset7))

        // Create an AssetHierarchyIterator
        val iterator = AssetIteratorFactory(assetList).create(AssetIteratorType.SIMPLE)

        // Test the iterator
        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset1, iterator.getValue())

        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(asset7, iterator.getValue())

        assertEquals(false, iterator.hasNext())
    }
}
