package org.exotechasset.exotechasset.FrameworkDriver

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AssetListFileTest {

    @Test
    fun writeFile() {
        val assetListFile = AssetListFile("./test.csv")
        val result = "\"Year\", \"Score\", \"Title\"\n" +
                "1968,  86, \"Greetings\"\n" +
                "1970,  17, \"Bloody Mama\"\n" +
                "1970,  73, \"Hi, Mom!\""
        val expect = result

        assetListFile.write(result)

        assertEquals(result, assetListFile.getContent())
    }
    @Test
    fun readFileTest(){
        val assetListFile = AssetListFile("read_test.csv")
        val expect = "\"Year\", \"Score\", \"Title\"\n" +
                "1968,  86, \"Greetings\"\n" +
                "1970,  17, \"Bloody Mama\"\n" +
                "1970,  73, \"Hi, Mom!\""

        assetListFile.readCsv()

        assertEquals(expect, assetListFile.getContent())
    }
}