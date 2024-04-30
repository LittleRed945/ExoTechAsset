package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.CompositeAsset

open class AssetHierarchyIterator : AssetIterator {

    private val stack: ArrayDeque<Iterator<Asset>> = ArrayDeque()

    public constructor(assetList: AssetList) : super(assetList) {
        this.stack.addLast(this.assetIterator)
    }

    public constructor(compositeAsset: CompositeAsset) : super(compositeAsset) {
        this.stack.addLast(this.assetIterator)
    }

    override public fun next() {
        while (this.stack.isNotEmpty()) {
            val iterator = this.stack.last()
            if (iterator.hasNext()) {
                this.asset = iterator.next()
                if (this.asset is CompositeAsset) {
                    val compositeAsset = this.asset as CompositeAsset
                    val children = compositeAsset.getChildren()
                    this.stack.addLast(children.iterator())
                }
                return
            } else {
                this.stack.removeLast()
            }
        }
        this.asset = null
    }

    override public fun hasNext(): Boolean {
        for (iterator in this.stack) {
            if (iterator.hasNext() == true) {
                return true
            }
        }
        return false
    }
}
