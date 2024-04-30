package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter

class EqualsToFilter(val param1: FilterParameter, val param2: FilterParameter) : Filter {
    override public fun meet(assetList: List<Asset>): List<Asset> {
        var result: MutableList<Asset> = mutableListOf()
        for (asset in assetList) {
            val get1 = param1.get(asset)
            val get2 = param2.get(asset)
            if ((get1 != null) && (get2 != null) && (get1 == get2)) {
                result.add(asset)
                continue
            }

            val str1 = param1.toString(asset)
            val str2 = param2.toString(asset)
            if ((str1 != null) && (str2 != null) && (str1 == str2)) {
                result.add(asset)
                continue
            }

            val num1 = param1.toNumber(asset)
            val num2 = param2.toNumber(asset)
            if ((num1 != null) && (num2 != null) && (num1 == num2)) {
                result.add(asset)
                continue
            }
        }
        return result
    }
}
