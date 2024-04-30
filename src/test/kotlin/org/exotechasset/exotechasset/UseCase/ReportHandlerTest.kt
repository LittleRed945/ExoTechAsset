package org.exotechasset.exotechasset.UseCase

import org.exotechasset.exotechasset.Entity.Metric
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ReportHandlerTest {

    @Test
    fun generateTableTest() {
        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to 1, AssetGetBy.STATUS to 2)
        var metric:Metric = Metric(mutablemap)
        ReportHandler().generateReport(ReportType.TABLE, metric)
    }
    @Test
    fun generateBarChartTest() {
        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to "x", AssetGetBy.STATUS to "y")
        var metric:Metric = Metric(mutablemap)
        ReportHandler().generateReport(ReportType.BAR, metric)
    }
    @Test
    fun generatePieChartTest() {
        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to 1, AssetGetBy.STATUS to 2)
        var metric:Metric = Metric(mutablemap)
        ReportHandler().generateReport(ReportType.PIE, metric)
    }
}