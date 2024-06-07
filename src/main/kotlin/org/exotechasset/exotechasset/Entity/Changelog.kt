package org.exotechasset.exotechasset.entity

class Changelog {
    private val changeLog: MutableList<String> = mutableListOf()

    public fun get(): List<String> = this.changeLog.toList()

    public fun add(log: String) {
        this.changeLog.add(log)
        check(log == this.changeLog.last())
    }
}
