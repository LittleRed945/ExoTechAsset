package org.exotechasset.exotechasset.entity

interface Filter {
    public fun meet(assetList: List<Asset>): List<Asset> = assetList
}
