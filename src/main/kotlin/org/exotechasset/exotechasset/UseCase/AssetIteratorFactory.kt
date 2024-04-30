package org.exotechasset.exotechasset.usecase

class AssetIteratorFactory(assetList: AssetList) {
    val assetList: AssetList = assetList

    public fun create(
            assetIteratorType: AssetIteratorType = AssetIteratorType.HIERARCHY
    ): AssetIterator =
            when (assetIteratorType) {
                AssetIteratorType.HIERARCHY -> AssetHierarchyIterator(this.assetList)
                AssetIteratorType.SIMPLE -> AssetIterator(this.assetList)
            }
}
