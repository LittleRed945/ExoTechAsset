package org.exotechasset.exotechasset.Usecase

class ScannerFactory {
    public fun get(assetListFile: AssetListFile): AbstractScanner{
        // TODO
        var csvScanner:CsvScanner = CsvScanner()
        csvScanner.get(assetListFile)
        return csvScanner
    }
}