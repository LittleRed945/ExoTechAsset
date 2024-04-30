package org.exotechasset.exotechasset.entity

abstract class AbstractVisitor {
    public abstract fun visit(asset:Asset);
    public abstract fun get():Any;
}