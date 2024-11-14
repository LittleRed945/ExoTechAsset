package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.entity.Metric
import org.exotechasset.exotechasset.entity.Report
import org.exotechasset.exotechasset.Usecase.AssetHandler

class ReportHandler(assetHandler: AssetHandler) {
    private var assetHandler:AssetHandler = assetHandler
    public fun generateReport(reportType: ReportType, metrics: Metric): Report{
        // TODO
        var report: Report
        report = ReportFactory().generate(reportType, metrics)
        assetHandler.accept(report)
        return report
    }
}
