package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.Usecase.Exporter
import org.exotechasset.exotechasset.Usecase.AssetHandler
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ExporterTest {

    @Test
    fun exportTest() {
        val assetHandler = AssetHandler()
        val exporter = Exporter(assetHandler)

        val asset1 = Asset("asset1")
        val asset2 = Asset("asset2")
        assetHandler.addNewAsset(asset1)
        assetHandler.addNewAsset(asset2)

        val assetListFile = exporter.export("test.csv")
        val expect = "id, status, assignee, auditDate, location, changelog, parentId\n" +
                "asset1, Deployable, null, null, , [], \n" +
                "asset2, Deployable, null, null, , [], \n"
        assetListFile.readCsv()
        assertEquals(expect, assetListFile.getContent())
    }
}