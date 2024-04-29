package org.exotechasset.exotechasset.UseCase

import org.exotechasset.exotechasset.Entity.AbstractScanner
import org.exotechasset.exotechasset.FrameworkDriver.AssetListFile
import org.exotechasset.exotechasset.Entity.CsvScanner
import org.exotechasset.exotechasset.Entity.ReportType
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ExporterImporterHandlerTest {

    @Test
    fun exportToTable() {
        // TODO
        var exporterHandler:ExporterImporterHandler = ExporterImporterHandler()
        exporterHandler.export(ReportType.Table, "./test.csv")
    }

    @Test
    fun import() {
        // TODO
        var assetListFile:AssetListFile = AssetListFile("./test.csv")
        var importerHandler:ExporterImporterHandler = ExporterImporterHandler()
        importerHandler.import(assetListFile, "Csv")


    }
}