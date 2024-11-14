package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.Usecase.Builder
import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.Usecase.AssetHandler
import org.exotechasset.exotechasset.Usecase.AssetList

class Importer(val assetHandler:AssetHandler) {
    private var builder: Builder = Builder()
    val ATTRIBUTE_NAMES = listOf("id", "status", "assignee", "auditDate", "location", "changelog", "assetDescription", "parentId")

    public fun import(assetListFile: AssetListFile):AssetList{
        val scannerFactory = ScannerFactory()
        val scanner = scannerFactory.get(assetListFile)
        while(scanner.hasNext()){
            val asset = buildAsset(scanner)
            val parentId = scanner.getNextToken()
            if(parentId == ""){
                this.assetHandler.addNewAsset(asset)
            }else{
                this.assetHandler.addNewAsset(asset, parentId)
            }
        }
        return this.assetHandler.cloneAssetList()
    }
    fun buildAsset(scanner: AbstractScanner):Asset{
        if (!scanner.hasNext()) {
            throw IllegalArgumentException("No more tokens")
        }
        var token:String = scanner.getNextToken()
        while(token in ATTRIBUTE_NAMES && scanner.hasNext()) {
            token = scanner.getNextToken()
        }
        builder.createNewAsset()
        builder.buildAssetId(token)
        token = scanner.getNextToken()
        builder.buildAssetStatus(token)
        token = scanner.getNextToken()
        builder.buildAssetAssignee(token)
        token = scanner.getNextToken()
        builder.buildAssetAuditDate(token)
        token = scanner.getNextToken()
        builder.buildAssetLocation(token)
        token = scanner.getNextToken()
//        buildAssetChangelog(token)

        val asset = builder.get()
        return asset
    }
}