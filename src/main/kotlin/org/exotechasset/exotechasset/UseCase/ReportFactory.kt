package org.exotechasset.exotechasset.UseCase
import org.exotechasset.exotechasset.Entity.*


class ReportFactory {
    public fun generate(reportType: ReportType, metrics:Metric) : Report{
        val report: Report
        when(reportType){
            ReportType.TABLE -> report = Table(metrics)
            ReportType.BAR -> report = BarChart(metrics)
            ReportType.PIE -> report = PieChart(metrics)
        }
        return report
    }
    public fun generateTable(reportType: ReportType, metrics:Metric) : Report{
        // TODO
        var report: Report = Table(metrics)
        return report
    }

    public fun generateBarChart(reportType: ReportType, metrics:Metric) : Report{
        // TODO
        var report: Report = Table(metrics)
        return report
    }

    public fun generatePieChart(reportType: ReportType, metrics:Metric) : Report{
        // TODO
        var report: Report = Table(metrics)
        return report
    }
}