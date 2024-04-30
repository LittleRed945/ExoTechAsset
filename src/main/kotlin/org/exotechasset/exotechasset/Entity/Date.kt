package org.exotechasset.exotechasset.entity

import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter.ISO_DATE_TIME

class Date(timestamp: Long, zone: ZoneOffset = ZoneOffset.UTC) {
    private val timestamp: Instant = Instant.ofEpochSecond(timestamp)
    private val zone: ZoneOffset = zone

    companion object {
        public fun ofNow() = Date(Instant.now().epochSecond)
    }
    public fun get(): Long = this.timestamp.epochSecond
    override public fun toString(): String =
            ZonedDateTime.ofInstant(this.timestamp, this.zone).format(ISO_DATE_TIME)
}
