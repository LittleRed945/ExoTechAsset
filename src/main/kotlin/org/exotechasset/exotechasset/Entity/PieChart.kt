package org.exotechasset.exotechasset.Entity

import org.exotechasset.exotechasset.UseCase.AssetGetBy

class PieChart (metrics: Metric): Chart(metrics) {
    var pieDatas:MutableMap<String, Double> = mutableMapOf<String, Double>()
    public override fun visit(asset:Asset){
        for(metric in metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> {
                    val value = datas["ID"]
                    value.add(asset.getId())
                    datas.put("ID",value)
                }
                AssetGetBy.STATUS -> {
                    val value = datas["Status"]
                    value.add(asset.getStatus())
                    datas.put("Status",value)
                }
                AssetGetBy.ASSIGNEE -> {
                    val value = datas["Assignee"]
                    value.add(asset.getAssignee())
                    datas.put("Assignee",value)
                }
                AssetGetBy.AUDITDATE -> {
                    val value = datas["Audit Date"]
                    value.add(asset.getAuditDate())
                    datas.put("Audit Date",value)
                }
                AssetGetBy.LOCATION -> {
                    val value = datas["Location"]
                    value.add(asset.getLocation())
                    datas.put("Location",value)
                }
                AssetGetBy.CHANGELOG -> {
                    val value = datas["Changelog"]
                    value.add(asset.getChangelog())
                    datas.put("Changelog",value)
                }
            }
        }
    }
    public override fun get(): MutableMap<String, Any> {

        var total:Int = 0
        for(data in datas){
            total += data.value.size
        }
        for(data in datas){
            val partion = data.value.size / total
            pieDatas.put(data.key, partion)
        }
        return pieDatas
    }
}