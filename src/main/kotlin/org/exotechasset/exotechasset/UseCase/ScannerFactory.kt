package org.exotechasset.exotechasset.UseCase
import org.exotechasset.exotechasset.Entity.AbstractScanner
import org.exotechasset.exotechasset.Entity.CsvScanner
import org.exotechasset.exotechasset.FrameworkDriver.AssetListFile

class ScannerFactory {
    public fun get(format:String, assetListFile: AssetListFile): AbstractScanner{
        // TODO
        var csvScanner:CsvScanner = CsvScanner()
        return csvScanner
    }
}