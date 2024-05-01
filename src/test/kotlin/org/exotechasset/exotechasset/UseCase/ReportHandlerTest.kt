package org.exotechasset.exotechasset.UseCase


import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.AssetGetBy
import org.exotechasset.exotechasset.entity.Metric
import org.exotechasset.exotechasset.useCase.ReportHandler
import org.exotechasset.exotechasset.useCase.ReportType
import org.exotechasset.exotechasset.usecase.AssetList
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ReportHandlerTest {

//    @Test
//    fun generateTableTest() {
//        val assetList = AssetList()
//        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to 1, AssetGetBy.STATUS to 2)
//        var metric: Metric = Metric(mutablemap)
//        var result:Any
//        var expects:Any
//        val asset1 = Asset("Asset 1")
//        val asset2 = Asset("Asset 2")
//
//        assetList.addNewAsset(asset1)
//        assetList.addNewAsset(asset2)
//        val report = ReportHandler(assetList).generateReport(ReportType.TABLE, metric)
//        result = report.get()
//        expects = mutableListOf<MutableList<String>>()
//        var expect: MutableList<String> = mutableListOf<String>()
//        expect.add("Asset 1");
//        expect.add("Deployable");
//        expects.add(expect)
//        expect.add("Asset 2");
//        expect.add("Deployable");
//        expects.add(expect)
//
//        assertTrue(expects == result)
//
//    }
//    @Test
//    fun generateBarChartTest() {
//        val assetList = AssetList()
//        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to "x", AssetGetBy.STATUS to "y")
//        var metric:Metric = Metric(mutablemap)
//        var result:Any
//        var expects:Any
//        val asset1 = Asset("Asset 1")
//        val asset2 = Asset("Asset 2")
//
//        assetList.addNewAsset(asset1)
//        assetList.addNewAsset(asset2)
//        val report = ReportHandler(assetList).generateReport(ReportType.BAR, metric)
//        result = report.get()
//        var expect = mutableMapOf<AssetGetBy, Any>()
//        expect.put(AssetGetBy.ID, "Asset 1");
//        expect.put(AssetGetBy.STATUS, "Deployable");
//        expect.put(AssetGetBy.ID, "Asset 2");
//        expect.put(AssetGetBy.STATUS, "Deployable");
//
//        assertTrue(expect == result)
//    }
//    @Test
//    fun generatePieChartTest() {
//        val assetList = AssetList()
//        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to 1, AssetGetBy.STATUS to 2)
//        var metric:Metric = Metric(mutablemap)
//        var result:Any
//        var expects:Any
//        val asset1 = Asset("Asset 1")
//        val asset2 = Asset("Asset 2")
//
//        assetList.addNewAsset(asset1)
//        assetList.addNewAsset(asset2)
//        val report = ReportHandler(assetList).generateReport(ReportType.PIE, metric)
//        result = report.get()
//        var expect = mutableMapOf<AssetGetBy, Any>()
//        expect.put(AssetGetBy.ID, 0.5);
//        expect.put(AssetGetBy.STATUS, 0.5);
//
//
//        assertTrue(expect == result)
//    }
}