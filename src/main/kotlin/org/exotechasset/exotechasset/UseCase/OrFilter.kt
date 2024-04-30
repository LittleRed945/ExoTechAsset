package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter

class OrFilter(val filterList: List<Filter>) : Filter {
    override public fun meet(assetList: List<Asset>): List<Asset> {
        var result: MutableSet<Asset> = mutableSetOf()
        for (filter in this.filterList) {
            result.addAll(filter.meet(assetList))
        }
        return result.toList()
    }
}
