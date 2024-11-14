package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter
import org.exotechasset.exotechasset.entity.FilterField

class EqualsToFilter(field: FilterField, value: Any) : Filter(field, value) {
    override public fun meet(assetList: List<Asset>): List<Asset> {
        var result: MutableList<Asset> = mutableListOf()
        for (asset in assetList) {
            // asset
            val assetStr = FilterValue(field).toString(asset)
            if (assetStr == null) {
                continue
            }
            // value
            if (value is String) {  // Checks if value is a String
                val valueStr = value  // No need for 'as String'
                if (assetStr == valueStr) {
                    result.add(asset)
                }
            }
        }
        return result
    }
}
