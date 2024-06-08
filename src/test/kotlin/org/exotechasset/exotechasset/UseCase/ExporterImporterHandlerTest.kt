package org.exotechasset.exotechasset.UseCase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.AssetGetBy
import org.exotechasset.exotechasset.useCase.ExporterImporterHandler
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ExporterImporterHandlerTest {

    @Test
    fun exportFileTest() {
        var assetList = AssetList()
        var asset1:Asset = Asset("asset1")
        var asset2:Asset = Asset("asset2")
        assetList.addNewAsset(asset1)
        assetList.addNewAsset(asset2)
        var exporterHandler: ExporterImporterHandler = ExporterImporterHandler()
        val assetListFile = exporterHandler.exportFile("./test.csv", assetList)
        val expect = "\"id\", \"status\", \"assignee\", \"auditDate\", \"location\", \"changelog\"\n" +
                "\"asset1\", \"Deployable\", \"null\", \"null\", \"\", \"[]\"\n" +
                "\"asset2\", \"Deployable\", \"null\", \"null\", \"\", \"[]\"\n"
        assetListFile.readCsv()
        assertEquals(expect, assetListFile.getContent())
    }
//
//    @Test
//    fun import() {
//        // TODO
//        var assetListFile:AssetListFile = AssetListFile("./test.csv")
//        var importerHandler:ExporterImporterHandler = ExporterImporterHandler()
//        importerHandler.import(assetListFile, "Csv")
//
//
//    }
}