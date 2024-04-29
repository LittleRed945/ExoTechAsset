package org.exotechasset.exotechasset.FrameworkDriver

import java.io.BufferedWriter
import java.nio.charset.StandardCharsets
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths


class AssetListFile(filePath:String) {
    private var filePath:String = filePath
    private var content: String = ""
    public fun write(result: String){
        content = result
        val file = File(filePath)
        // Create a FileWriter to write to the file
        val writer = FileWriter(file)

        // Write content to the file
        writer.write(content)

        // Close the FileWriter
        writer.close()
    }

    public fun readCsv(){
        val bytes = Files.readAllBytes(Paths.get("file.txt"))
        content = String(bytes, StandardCharsets.UTF_8)
    }

    public fun getContent():String{
        return content
    }
}