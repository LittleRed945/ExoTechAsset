package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.CompositeAsset

open class AssetIterator {
    protected var assetIterator: Iterator<Asset> = listOf<Asset>().iterator()
    protected var asset: Asset? = null

    public constructor(assetList: AssetList) {
        val childrenAssetList: List<Asset> = assetList.getChildren()
        this.assetIterator = childrenAssetList.iterator()
    }
    public constructor(compositeAsset: CompositeAsset) {
        val childrenAssetList: List<Asset> = compositeAsset.getChildren()
        this.assetIterator = childrenAssetList.iterator()
    }

    public open fun next() {
        asset = this.assetIterator.next()
    }

    public open fun hasNext() = this.assetIterator.hasNext()

    public open fun getValue() = this.asset
}
