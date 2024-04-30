package org.exotechasset.exotechasset.Entity

class Asset;
abstract class AbstractVisitor {
    public abstract fun visit(asset:Asset);
    public abstract fun get():Any;
}