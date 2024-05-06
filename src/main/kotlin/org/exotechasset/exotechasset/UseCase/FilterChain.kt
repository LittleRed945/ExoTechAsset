package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Filter

class FilterChain(assetList: AssetList) {
    private val assetList: AssetList = assetList
    private var filterList: MutableSet<Filter> = mutableSetOf()

    public fun addFilter(filter: Filter) {
        this.filterList.add(filter)
    }

    public fun clearFilter() {
        this.filterList.clear()
    }

    public fun filterAsset(): AssetList {
        var filteredAssetList = assetList.getChildren()
        for (filter in this.filterList) {
            filteredAssetList = filter.meet(filteredAssetList)
        }
        return AssetList(filteredAssetList)
    }

    public fun getFilterList(): List<Filter> = this.filterList.toList()

    public fun size() = this.filterList.size
}
