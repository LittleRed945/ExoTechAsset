package org.exotechasset.exotechasset.Entity
import org.exotechasset.exotechasset.Entity.AbstractVisitor

abstract class Report  (metrics: Metric ): AbstractVisitor() {
    public var metrics:Metric = metrics
}