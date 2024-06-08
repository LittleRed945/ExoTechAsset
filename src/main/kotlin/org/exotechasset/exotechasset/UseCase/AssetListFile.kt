package org.exotechasset.exotechasset.useCase

import java.io.BufferedWriter
import java.nio.charset.StandardCharsets
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths


class AssetListFile(filePath:String) {
    // TODO 未來會把實作依照依賴反轉原則抽離到FrameworkDriver層
    private var filePath:String = filePath
    private var content: String = ""
    public fun write(result: String){
        content = result
        val file = File(filePath)
        // Create a FileWriter to write to the file
        if(!file.exists()){
            file.createNewFile()
        }

        // Write content to the file
        file.writeText(content)
    }

    public fun readCsv(){
        val bytes = Files.readAllBytes(Paths.get(filePath))
        content = String(bytes, StandardCharsets.UTF_8)
    }

    public fun getContent():String{
        return content
    }
}