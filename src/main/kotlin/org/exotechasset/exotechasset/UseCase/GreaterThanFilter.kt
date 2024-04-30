package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter

class GreaterThanFilter(val param1: FilterParameter, val param2: FilterParameter) : Filter {
    override public fun meet(assetList: List<Asset>): List<Asset> {
        var result: MutableList<Asset> = mutableListOf()
        for (asset in assetList) {
            val get1 = param1.toNumber(asset)
            val get2 = param2.toNumber(asset)
            if ((get1 == null) || (get2 == null)) {
                continue
            }

            val num1:Long = get1
            val num2:Long = get2
            if (num1 > num2) {
                result.add(asset)
            }
        }
        return result
    }
}
