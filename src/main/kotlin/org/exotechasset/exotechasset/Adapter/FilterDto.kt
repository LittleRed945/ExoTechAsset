package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.entity.Filter
import org.exotechasset.exotechasset.entity.FilterField
import org.exotechasset.exotechasset.usecase.FilterFactory
import org.exotechasset.exotechasset.usecase.FilterType
import org.json.JSONArray
import org.json.JSONObject

data class FilterDto(val field: String, val operator: String, val value: String) {

    constructor(
            filter: Filter
    ) : this(filter.field.toString(), FilterType.of(filter).toString(), filter.value.toString())

    fun toJSONObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("field", this.field.toString())
        jsonObject.put("operator", this.operator.toString())
        jsonObject.put("value", this.value.toString())
        return jsonObject
    }

    fun toFilter(): Filter {
        return FilterFactory().createWithStr(this.operator,this.field, this.value)
    }

    companion object {
        fun fromJSONObject(jsonObject: JSONObject): FilterDto {
            return FilterDto(
                    field = jsonObject.getString("field"),
                    operator = jsonObject.getString("operator"),
                    value = jsonObject.optString("value")
            )
        }

        fun fromJSONArray(jsonArray: JSONArray): List<FilterDto> {
            val filterDtoList = mutableListOf<FilterDto>()
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                filterDtoList.add(fromJSONObject(jsonObject))
            }
            return filterDtoList
        }
    }
}
