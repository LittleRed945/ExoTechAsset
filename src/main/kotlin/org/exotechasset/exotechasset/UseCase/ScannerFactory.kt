package org.exotechasset.exotechasset.useCase

class ScannerFactory {
    public fun get(format:String, assetListFile: AssetListFile): AbstractScanner{
        // TODO
        var csvScanner:CsvScanner = CsvScanner()
        return csvScanner
    }
}