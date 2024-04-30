package org.exotechasset.exotechasset.UseCase


import org.exotechasset.exotechasset.entity.AssetGetBy
import org.exotechasset.exotechasset.entity.Metric
import org.exotechasset.exotechasset.useCase.ReportHandler
import org.exotechasset.exotechasset.useCase.ReportType
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ReportHandlerTest {

    @Test
    fun generateTableTest() {
        var mutablemap  = mutableMapOf<AssetGetBy, Any>(AssetGetBy.ID to 1, AssetGetBy.STATUS to 2)
        var metric: Metric = Metric(mutablemap)
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