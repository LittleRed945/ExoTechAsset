package org.exotechasset.exotechasset.entity

abstract class Filter(field:FilterField, value:Any) {
    public val field: FilterField = field
    public val value: Any = value

    open public fun meet(assetList: List<Asset>): List<Asset> = assetList
}
