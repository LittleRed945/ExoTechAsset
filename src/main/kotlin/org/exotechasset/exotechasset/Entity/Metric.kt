package org.exotechasset.exotechasset.Entity

import org.exotechasset.exotechasset.UseCase.AssetGetBy

class Metric(metrics: MutableMap<AssetGetBy, Any>) {
    private val metrics = metrics
    public fun addMetrics(assetGetBy: AssetGetBy, any: Any){
        metrics.put(assetGetBy, any)
    }
    public fun getMetrics(): MutableMap<AssetGetBy, Any>{
        return metrics
    }
}