package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Filter

class FilterList(val assetHandler: AssetHandler) {
    private var filterList: MutableSet<Filter> = mutableSetOf()

    public fun addFilter(filter: Filter) {
        this.filterList.add(filter)
    }

    public fun clearFilter() {
        this.filterList.clear()
    }

    public fun filterAsset(): AssetList {
        var filteredAssetList = this.assetHandler.getChildren()
        for (filter in this.filterList) {
            filteredAssetList = filter.meet(filteredAssetList)
        }
        return AssetList(filteredAssetList)
    }

    public fun getFilterList(): List<Filter> = this.filterList.toList()

    public fun size() = this.filterList.size
}
