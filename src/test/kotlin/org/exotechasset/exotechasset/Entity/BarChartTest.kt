package org.exotechasset.exotechasset.Entity

import org.exotechasset.exotechasset.entity.*
import org.exotechasset.exotechasset.entity.AssetStatus.DEPLOYABLE
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BarChartTest {

    @Test
    fun getBarDatas() {
        val metric = Metric(mutableMapOf<AssetGetBy, Any>());
        metric.addMetrics(AssetGetBy.ID, "1");
        metric.addMetrics(AssetGetBy.STATUS, "2");
        var barChart: BarChart = BarChart(metric);
        val asset: Asset = Asset("AS-01");
        var expect:MutableMap<AssetGetBy, Any> = mutableMapOf<AssetGetBy, Any>()

        expect.put(AssetGetBy.ID, "AS-01");
        expect.put(AssetGetBy.STATUS, "Deployable");
        asset.accept(barChart);

        assertTrue(expect == barChart.get());
    }
}