package org.exotechasset.exotechasset.useCase

abstract class AbstractScanner {
    public abstract fun get(format:String, assetListFile: AssetListFile);
    public abstract fun getNextToken(): String;
}