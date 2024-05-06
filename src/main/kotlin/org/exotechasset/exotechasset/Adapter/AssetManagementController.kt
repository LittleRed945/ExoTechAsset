package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.usecase.AssetIterator
import org.exotechasset.exotechasset.usecase.AssetList
import org.exotechasset.exotechasset.usecase.FilterChain
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AssetManagementController {
    private val assetList: AssetList = ServiceController.assetList

    @GetMapping("/assets")
    public fun getAssetIdList(): String {
        val response: JSONObject = JSONObject()
        val iterator: AssetIterator = this.assetList.createIterator()
        while (iterator.hasNext()) {
            iterator.next()
            val asset: Asset = iterator.getValue()!!

            val assetJsonObject: JSONObject = AssetDto(asset).toJSONObject()
            response.put(asset.getId(), assetJsonObject)
        }
        return response.toString()
    }
    @GetMapping("/assets/{id}")
    public fun getAsset(@PathVariable(value = "id") id: String): String {
        val asset:Asset? = this.assetList.getAsset(id)
        if (asset == null) {
            // TODO: error handling
            return "{\n}"
        }

        val response: JSONObject = JSONObject()
        response.put(id, AssetDto(asset).toJSONObject())

        return response.toString()
    }

    @PostMapping("/assets")
    fun addAsset(@RequestBody assetDto: AssetDto) {
        val asset = assetDto.toAsset()
        this.assetList.addNewAsset(asset)
    }

    @DeleteMapping("/assets/{id}")
    fun deleteAsset(@PathVariable(value = "id") id: String) {
        this.assetList.deleteAsset(id)
    }

    @PutMapping("/assets/{id}")
    fun modifyAsset(@PathVariable(value = "id") id: String, @RequestBody assetDto: AssetDto) {
        val updatedAsset = assetDto.toAsset()
        try {
            this.assetList.modifyAsset(updatedAsset)
        }
        catch(exception: IllegalArgumentException) {
            // TODO
        }
    }
}
