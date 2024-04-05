package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Filter

class FilterList {
    companion object {
        private final val FILTER_LIST = listOf<Filter>()
    }

    public fun getAll(): Collection<Filter> = FILTER_LIST

    public fun size() = FILTER_LIST.size
}
