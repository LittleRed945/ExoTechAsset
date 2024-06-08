package org.exotechasset.exotechasset.entity

import org.json.JSONObject


class BarChart (metrics: Metric = Metric(), datas: JSONObject = JSONObject()): Chart(metrics, datas) {
    public override fun visit(asset:Asset){
        for(metric in super.metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> super.datas.accumulate("id", asset.getId())
                AssetGetBy.STATUS -> super.datas.accumulate("status", asset.getStatus().toString())
                AssetGetBy.ASSIGNEE -> super.datas.accumulate("assignee", asset.getAssignee().toString())
                AssetGetBy.AUDITDATE -> super.datas.accumulate("auditDate", asset.getAuditDate().toString())
                AssetGetBy.LOCATION -> super.datas.accumulate("location", asset.getLocation()?.get() ?: Location("").get())
                AssetGetBy.CHANGELOG -> super.datas.accumulate("changelog", asset.getChangelog().get())
            }
        }
    }
    public override fun get(): JSONObject{
        return datas
    }


}