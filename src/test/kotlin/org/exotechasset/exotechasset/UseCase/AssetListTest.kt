import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AssetListTest {
    @Test
    fun testAssetList() {
        val asset1 = Asset("Asset 1")
        val asset2 = Asset("Asset 2")
        val asset3 = Asset("Asset 3")

        val assetList = AssetList()

        assertEquals(0, assetList.size())

        assetList.addNewAsset(asset1)
        assetList.addNewAsset(asset2)
        assetList.addNewAsset(asset3)

        assertEquals(3, assetList.size())

        assertEquals(asset1, assetList.getAsset("Asset 1"))
        assertEquals(asset2, assetList.getAsset("Asset 2"))
        assertEquals(asset3, assetList.getAsset("Asset 3"))
    }
}
