package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter

class AndFilter(val filterList: List<Filter>) : Filter {
    override public fun meet(assetList: List<Asset>): List<Asset> {
        var result: List<Asset> = assetList
        for (filter in this.filterList) {
            result = filter.meet(result)
        }
        return result
    }
}
