package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.AssetStatus
import org.exotechasset.exotechasset.entity.Date
import org.exotechasset.exotechasset.entity.Location
import org.exotechasset.exotechasset.Usecase.AbstractScanner
import org.exotechasset.exotechasset.Usecase.CsvScanner
import java.time.Instant
import java.time.ZonedDateTime


public class Builder {
    private lateinit var asset:Asset


    fun createNewAsset(){
        asset = Asset("")
    }
    fun buildAssetId(id: String){
        asset = Asset(id)
    }


    fun buildAssetStatus(status: String){
        when(status){
            "Deployable" -> asset.setStatus(AssetStatus.DEPLOYABLE)
            "Pending" -> asset.setStatus(AssetStatus.PENDING)
            "Deployed" -> asset.setStatus(AssetStatus.DEPLOYED)
            "Undeployable" -> asset.setStatus(AssetStatus.UNDEPLOYABLE)
        }
    }
    fun buildAssetLocation(location: String){
        asset.setLocation(Location(location))
    }
    fun buildAssetAssignee(assignee: String?){
        asset.setAssignee(assignee)
    }
    fun buildAssetAuditDate(auditDate: String){
        try {
            val zoneDate: ZonedDateTime = ZonedDateTime.parse(auditDate)
            val date = Date(zoneDate.toInstant().epochSecond)
            asset.setAuditDate(date)
        }catch (e: Exception) {
//            asset.setAuditDate(null)
        }
    }
    fun get(): Asset {
        return asset
    }
}
