package org.exotechasset.exotechasset.Entity
import org.exotechasset.exotechasset.Entity.Report
import org.exotechasset.exotechasset.UseCase.AssetGetBy

class Table(metrics: Metric): Report(metrics){
    private var datas: MutableList<MutableList<String>> = mutableListOf<MutableList<String>>()
    public override fun visit(asset:Asset){
        // Todo
        val data = mutableListOf<String>()
        for(metric in metrics.getMetrics()){
            when(metric.key){
                AssetGetBy.ID -> data.add(asset.getId())
                AssetGetBy.STATUS -> data.add(asset.getStatus())
                AssetGetBy.ASSIGNEE -> data.add(asset.getAssignee())
                AssetGetBy.AUDITDATE -> data.add(asset.getAuditDate())
                AssetGetBy.LOCATION -> data.add(asset.getLocation())
                AssetGetBy.CHANGELOG -> data.add(asset.getChangelog())
            }
        }
        datas.add(data)
    }
    public override fun get(): MutableList<MutableList<String>>{
        // Todo
        return datas
    }
}