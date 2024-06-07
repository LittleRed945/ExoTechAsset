package org.exotechasset.exotechasset.useCase

import org.exotechasset.exotechasset.entity.AbstractVisitor

class VisitorFactory {
    public fun get(exportType: ReportType): AbstractVisitor {
        // TODO
        var csvVisitor: CsvVisitor = CsvVisitor()
        return csvVisitor
    }
}