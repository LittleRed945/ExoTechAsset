package org.exotechasset.exotechasset.UseCase
import org.exotechasset.exotechasset.Entity.Metric
import org.exotechasset.exotechasset.UseCase.ReportFactory
import org.exotechasset.exotechasset.Entity.Report
import org.exotechasset.exotechasset.UseCase.ReportType

class ReportHandler {
    public fun generateReport(reportType: ReportType, metrics:Metric){
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