package org.exotechasset.exotechasset.Usecase

import org.exotechasset.exotechasset.Usecase.AssetListFile
import org.exotechasset.exotechasset.Usecase.CsvScanner
import org.exotechasset.exotechasset.Usecase.ScannerFactory
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ScannerFactoryTest {

    @Test
    fun getCsvScanner() {
        val scannerFactory = ScannerFactory()
        val assetListFile = AssetListFile("./test.csv")
        val scanner = scannerFactory.get(assetListFile)
        assertTrue(scanner is CsvScanner)
    }
}