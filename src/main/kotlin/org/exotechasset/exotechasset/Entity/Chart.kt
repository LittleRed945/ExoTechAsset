package org.exotechasset.exotechasset.entity



abstract class Chart(metrics: Metric): Report(metrics) {
    protected var datas: MutableMap<AssetGetBy, MutableList<Any>> = mutableMapOf<AssetGetBy, MutableList<Any>>()

}