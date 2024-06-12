package org.exotechasset.exotechasset.entity

import org.json.JSONArray
import org.json.JSONObject

class Table(metrics: Metric): Report(metrics){
    private var datas: JSONArray = JSONArray()
    public override fun visit(asset:Asset){
        val data = JSONObject()
        for(metric in metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> {
                    data.accumulate("id", asset.getId())
                }
                AssetGetBy.STATUS -> {
                    data.accumulate("status", asset.getStatus().toString())
                }
                AssetGetBy.ASSIGNEE -> {
                    data.accumulate("assignee", asset.getAssignee().toString())
                }
                AssetGetBy.AUDITDATE -> {
                    data.accumulate("auditDate", asset.getAuditDate().toString())
                }
                AssetGetBy.LOCATION -> {
                    data.accumulate("location", asset.getLocation()?.get() ?: Location("").get())
                }
                AssetGetBy.CHANGELOG -> {
                    data.accumulate("changelog", asset.getChangelog().get())
                }
            }
        }
        this.datas.put(data)
    }
    public override fun get(): JSONArray{
        return this.datas
    }
}
