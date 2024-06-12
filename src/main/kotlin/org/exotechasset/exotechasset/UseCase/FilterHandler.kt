package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Filter

class FilterHandler(val assetHandler: AssetHandler) {
    private var filterList: FilterList = FilterList(assetHandler)

    public fun addFilter(filter: Filter) {
        this.filterList.addFilter(filter)
    }

    public fun clearFilter() {
        this.filterList.clearFilter()
    }

    public fun filterAsset(): AssetList = this.filterList.filterAsset()

    public fun getFilterList(): List<Filter> = this.filterList.getFilterList()

    public fun size() = this.filterList.size()
}
