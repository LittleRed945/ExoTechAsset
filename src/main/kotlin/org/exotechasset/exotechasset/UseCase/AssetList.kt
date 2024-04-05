package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset

// TODO: avoid the same id

class AssetList {
    private var assetList: MutableMap<String, Asset> = mutableMapOf()

    public constructor() {}

    public constructor(assetList: AssetList) {
        // create a shallow copy for assetList:MutableMap
        this.assetList = assetList.assetList.toMutableMap()
    }

    public constructor(assetList: List<Asset>) {
        // create a shallow copy for assetList:MutableMap
        this.assetList = assetList.map { it.getId() to it }.toMap().toMutableMap()
    }

    public fun size() = this.assetList.size

    public fun addNewAsset(asset: Asset) {
        val id: String = asset.getId()
        this.assetList.put(id, asset)
    }

    public fun getAsset(id: String): Asset? = this.assetList.get(id)

    public fun modifyAsset(asset: Asset): Boolean {
        val id: String = asset.getId()
        val assetInThis = this.getAsset(id)
        assetInThis?.modify(asset)
        return (assetInThis != null)
    }

    public fun deleteAsset(id: String) {
        this.assetList.remove(id)
    }

    public fun deleteAsset(asset: Asset) {
        val id: String = asset.getId()
        this.deleteAsset(id)
    }

    public fun auditAsset(id: String) {
        val asset: Asset? = this.getAsset(id)
        asset?.audit()
    }

    public fun getChildren(): List<Asset> = this.assetList.values.toList()

    public fun createIterator(assetIteratorType: AssetIteratorType): AssetIterator =
            AssetIteratorFactory(this).create(assetIteratorType)

    // TODO: implementation
    // public fun accept(visitor:AbstractVisitor) {
    //     visitor.visit(this)
    // }

    public fun clone(): AssetList = AssetList(this)
}
