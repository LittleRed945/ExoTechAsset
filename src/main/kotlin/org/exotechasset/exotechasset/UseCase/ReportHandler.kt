package org.exotechasset.exotechasset.useCase

import org.exotechasset.exotechasset.entity.Metric
import org.exotechasset.exotechasset.entity.Report

class ReportHandler {
    public fun generateReport(reportType: ReportType, metrics: Metric){
        // TODO
        var report: Report
        if(reportType == ReportType.TABLE){
            report = ReportFactory().generate(reportType, metrics)
        }else if(reportType == ReportType.BAR){
            report = ReportFactory().generate(reportType, metrics)
        }else if(reportType == ReportType.PIE){
            report = ReportFactory().generate(reportType, metrics)
        }

    }
}