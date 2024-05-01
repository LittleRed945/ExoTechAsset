package org.exotechasset.exotechasset.entity

class Table(metrics: Metric): Report(metrics){
    private var datas: MutableList<MutableList<String>> = mutableListOf<MutableList<String>>()
    public override fun visit(asset:Asset){
        val data = mutableListOf<String>()
        for(metric in metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> data.add(asset.getId())
                AssetGetBy.STATUS -> data.add(asset.getStatus().toString())
                AssetGetBy.ASSIGNEE -> data.add(asset.getAssignee().toString())
                AssetGetBy.AUDITDATE -> data.add(asset.getAuditDate().toString())
                AssetGetBy.LOCATION -> data.add(asset.getLocation().toString())
                AssetGetBy.CHANGELOG -> data.add(asset.getChangelog().toString())
            }
        }
        datas.add(data)
    }
    public override fun get(): MutableList<MutableList<String>>{
        // Todo
        return datas
    }
}