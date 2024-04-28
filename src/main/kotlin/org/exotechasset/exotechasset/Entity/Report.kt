package org.exotechasset.exotechasset.Entity
import org.exotechasset.exotechasset.Entity.AbstractVisitor

abstract class Report  (metrics: List<Number> ): AbstractVisitor() {
    private var metrics:List<Number> = metrics
}