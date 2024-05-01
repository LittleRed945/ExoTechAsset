import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.CompositeAsset
import org.exotechasset.exotechasset.usecase.AssetHierarchyIterator
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class AssetHierarchyIteratorTest {
    @Test
    fun testAssetHierarchyIterator() {
        // Create a sample asset hierarchy
        val asset1 = CompositeAsset("AS-01")
        val asset2 = CompositeAsset("AS-02")
        val asset3 = CompositeAsset("AS-03")
        val asset4 = Asset("AS-04")
        val asset5 = Asset("AS-05")
        val asset6 = Asset("AS-06")

        asset1.addChild(asset2)
        asset1.addChild(asset3)
        asset2.addChild(asset4)
        asset2.addChild(asset5)
        asset3.addChild(asset6)

        // Create an AssetHierarchyIterator
        val iterator = AssetHierarchyIterator(AssetList(listOf(asset1)))

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

        assertEquals(false, iterator.hasNext())
    }

    @Test
    fun testNext() {
        // Create a sample asset hierarchy
        val asset1 = Asset("AS-01")

        // Create an AssetHierarchyIterator
        val iterator = AssetHierarchyIterator(AssetList(listOf(asset1)))
        iterator.next()
        // Test the iterator
        assertEquals(asset1, iterator.getValue())
    }

    @Test
    fun testHasNext() {
        // Create a sample asset hierarchy
        val asset1 = CompositeAsset("AS-01")
        val asset2 = Asset("AS-02")

        asset1.addChild(asset2)


        // Create an AssetHierarchyIterator
        val iterator = AssetHierarchyIterator(AssetList(listOf(asset1)))

        // Test the iterator
        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertEquals(true, iterator.hasNext())
        iterator.next()
        assertFalse(iterator.hasNext())
    }
}
