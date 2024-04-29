package org.exotechasset.exotechasset.entity

class Changelog(changeLog:List<String> = emptyList()) {
    private val changeLog: MutableList<String> = changeLog.toMutableList()

    public fun get(): List<String> = this.changeLog.toList()

    public fun add(log: String) {
        this.changeLog.add(log)
        check(log == this.changeLog.last())
    }
}
