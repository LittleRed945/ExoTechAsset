package org.exotechasset.exotechasset.Entity

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.AssetGetBy
import org.exotechasset.exotechasset.entity.Metric
import org.exotechasset.exotechasset.entity.PieChart
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PieChartTest {

    @Test
    fun getPieDatas() {
        val metric = Metric(mutableMapOf<AssetGetBy, Any>());
        metric.addMetrics(AssetGetBy.ID, "1");
        metric.addMetrics(AssetGetBy.STATUS, "2");
        var pieChart:PieChart = PieChart(metric);
        val asset: Asset = Asset("AS-01");
        var expect:MutableMap<AssetGetBy, Double> = mutableMapOf<AssetGetBy, Double>()

        expect.put(AssetGetBy.ID, 0.5);
        expect.put(AssetGetBy.STATUS, 0.5);
        asset.accept(pieChart);

        assertTrue(expect == pieChart.get());
    }
}