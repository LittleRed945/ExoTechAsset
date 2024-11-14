package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.Filter
import org.exotechasset.exotechasset.Usecase.AssetIterator
import org.exotechasset.exotechasset.Usecase.AssetHandler
import org.exotechasset.exotechasset.Usecase.FilterHandler
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FilterController {
    private val assetHandler: AssetHandler = ServiceController.assetHandler
    private val filterHandler: FilterHandler = ServiceController.filterHandler

    @GetMapping("/filters")
    public fun getFilterList(): String {
        val json = JSONObject()
        val array = JSONArray()
        for (filter in this.filterHandler.getFilterList()) {
            array.put(FilterDto(filter).toJSONObject())
        }
        json.put("filters", array)
        return json.toString()
    }

    @PostMapping("/filters")
    fun addFilter(@RequestBody filterDto: FilterDto) {
        val filter: Filter = filterDto.toFilter()
        this.filterHandler.addFilter(filter)
    }

    @DeleteMapping("/filters")
    fun clearFilter() {
        this.filterHandler.clearFilter()
    }

    @GetMapping("/filters/assets")
    public fun getFilterAsset(): String {
        val response: JSONObject = JSONObject()
        val iterator: AssetIterator = this.filterHandler.filterAsset().createIterator()
        while (iterator.hasNext()) {
            iterator.next()
            val asset: Asset = iterator.getValue()!!

            val assetJsonObject: JSONObject = AssetDto(asset).toJSONObject()
            response.put(asset.getId(), assetJsonObject)
        }
        return response.toString()
    }
}
