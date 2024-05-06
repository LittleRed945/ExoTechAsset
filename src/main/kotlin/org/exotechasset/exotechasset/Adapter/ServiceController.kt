package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.usecase.AssetList
import org.exotechasset.exotechasset.usecase.FilterChain

object ServiceController {
    public val assetList: AssetList = AssetList()
    public val filterChain: FilterChain = FilterChain(this.assetList)
}
