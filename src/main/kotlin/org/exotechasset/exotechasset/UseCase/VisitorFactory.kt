package org.exotechasset.exotechasset.UseCase
import org.exotechasset.exotechasset.Entity.AbstractVisitor
import org.exotechasset.exotechasset.Entity.CsvVisitor

class VisitorFactory {
    public fun get(exportType: ReportType): AbstractVisitor{
        // TODO
        var csvVisitor: CsvVisitor = CsvVisitor()
        return csvVisitor
    }
}