package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.Usecase.AssetHandler
import org.exotechasset.exotechasset.Usecase.AssetList

class ExporterImporterHandler(val assetHandler:AssetHandler) {

    public fun exportFile(filePath:String): AssetListFile{
        var exporter = Exporter(this.assetHandler)
        return exporter.export(filePath)
    }

    public fun importFile(assetListFile: AssetListFile): AssetList{
        var importer = Importer(this.assetHandler)
        return importer.import(assetListFile)
    }
}