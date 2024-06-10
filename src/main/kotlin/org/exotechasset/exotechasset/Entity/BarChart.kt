package org.exotechasset.exotechasset.entity

import org.json.JSONObject


class BarChart (metrics: Metric = Metric(), datas: JSONObject = JSONObject()): Chart(metrics, datas) {
    public override fun visit(asset:Asset){
        for(metric in super.metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> super.datas.accumulate(metric.value.toString(), asset.getId())
                AssetGetBy.STATUS -> super.datas.accumulate(metric.value.toString(), asset.getStatus().toString())
                AssetGetBy.ASSIGNEE -> super.datas.accumulate(metric.value.toString(), asset.getAssignee().toString())
                AssetGetBy.AUDITDATE -> super.datas.accumulate(metric.value.toString(), asset.getAuditDate().toString())
                AssetGetBy.LOCATION -> super.datas.accumulate(metric.value.toString(), asset.getLocation()?.get())
                AssetGetBy.CHANGELOG -> super.datas.accumulate(metric.value.toString(), asset.getChangelog().toString())
            }
        }
    }
    public override fun get(): JSONObject{
        return datas
    }


}