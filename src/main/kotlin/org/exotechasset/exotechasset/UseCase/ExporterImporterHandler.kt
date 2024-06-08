package org.exotechasset.exotechasset.useCase

import org.exotechasset.exotechasset.usecase.AssetList

class ExporterImporterHandler {
    public fun exportFile(filePath:String, assetList: AssetList): AssetListFile{
        var exporter = Exporter()
        return exporter.export(filePath, assetList)
    }
//    public fun import(assetListFile: AssetListFile, format: String){
//
//    }
}