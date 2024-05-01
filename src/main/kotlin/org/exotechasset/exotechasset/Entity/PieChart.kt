package org.exotechasset.exotechasset.entity

class PieChart (metrics: Metric): Chart(metrics) {
    var pieDatas:MutableMap<AssetGetBy, Double> = mutableMapOf<AssetGetBy, Double>()
    public override fun visit(asset:Asset){
        for(metric in metrics.getMetrics()){
            var value:MutableList<Any> = mutableListOf<Any>()
            if(datas.containsKey(metric.key)) {
                value = datas.getValue(metric.key)
            }
            when(metric.key){
                AssetGetBy.ID -> {
                    value.add(asset.getId())
                }
                AssetGetBy.STATUS -> {
                    value.add(asset.getStatus().toString())
                }
                AssetGetBy.ASSIGNEE -> {
                    value.add(asset.getAssignee().toString())
                }
                AssetGetBy.AUDITDATE -> {
                    value.add(asset.getAuditDate().toString())
                }
                AssetGetBy.LOCATION -> {
                    value.add(asset.getLocation().toString())
                }
                AssetGetBy.CHANGELOG -> {
                    value.add(asset.getChangelog().toString())
                }
            }
            datas.put(metric.key ,value)
        }
    }
    public override fun get(): MutableMap<AssetGetBy, Double> {

        var total:Int = 0
        for(data in datas){
            total += data.value.size
        }
        for(data in datas){
            val partion =data.value.size / total * 1.0
            pieDatas.put(data.key, partion)
        }
        return pieDatas
    }
}