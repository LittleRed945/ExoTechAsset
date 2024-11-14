package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Report
import org.exotechasset.exotechasset.Usecase.AssetHandler

import java.io.File

class Exporter(val assetHandler:AssetHandler) {
    
    public fun export(filePath:String): AssetListFile{

        var assetListFile:AssetListFile = AssetListFile(filePath)
        var report = ReportFactory().generate(ReportType.CSV)
        assetHandler.accept(report)
        val result:String = report.get().toString()

        assetListFile.write(result)
        return assetListFile
    }
}
