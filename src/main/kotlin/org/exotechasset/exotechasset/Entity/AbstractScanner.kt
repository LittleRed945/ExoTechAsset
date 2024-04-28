package org.exotechasset.exotechasset.Entity
import org.exotechasset.exotechasset.Entity.AssetListFile

abstract class AbstractScanner {
    public abstract fun get(format:String, assetListFile: AssetListFile);
    public abstract fun getNextToken(): String;
}