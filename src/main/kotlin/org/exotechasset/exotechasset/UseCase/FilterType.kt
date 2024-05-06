package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Filter
import org.exotechasset.exotechasset.entity.ToStringInterface

enum class FilterType : ToStringInterface {
    EQUALS_TO {
        override public fun toString(): String = "EqualsTo"
    },
    NOT_EQUALS_TO {
        override public fun toString(): String = "NotEqualsTo"
    },
    GREATER_THAN {
        override public fun toString(): String = "GreaterThan"
    },
    GREATER_THAN_OR_EQUALS_TO {
        override public fun toString(): String = "GreaterThanOrEqualsTo"
    },
    LESS_THAN {
        override public fun toString(): String = "LessThan"
    },
    LESS_THAN_OR_EQUALS_TO {
        override public fun toString(): String = "LessThanOrEqualsTo"
    };

    companion object {
        public fun of(filter: Filter): FilterType =
                when (filter) {
                    is EqualsToFilter -> FilterType.EQUALS_TO
                    is NotEqualsToFilter -> FilterType.NOT_EQUALS_TO
                    is GreaterThanFilter -> FilterType.GREATER_THAN
                    is GreaterThanOrEqualsToFilter -> FilterType.GREATER_THAN_OR_EQUALS_TO
                    is LessThanFilter -> FilterType.LESS_THAN
                    is LessThanOrEqualsToFilter -> FilterType.LESS_THAN_OR_EQUALS_TO
                    else -> throw IllegalArgumentException("Unknown filter type")
                }

        public fun of(filterTypeStr: String): FilterType =
                when (filterTypeStr) {
                    "EqualsTo" -> FilterType.EQUALS_TO
                    "NotEqualsTo" -> FilterType.NOT_EQUALS_TO
                    "GreaterThan" -> FilterType.GREATER_THAN
                    "GreaterThanOrEqualsTo" -> FilterType.GREATER_THAN_OR_EQUALS_TO
                    "LessThan" -> FilterType.LESS_THAN
                    "LessThanOrEqualsTo" -> FilterType.LESS_THAN_OR_EQUALS_TO
                    else -> throw IllegalArgumentException("Unknown filter type")
                }
    }
}
