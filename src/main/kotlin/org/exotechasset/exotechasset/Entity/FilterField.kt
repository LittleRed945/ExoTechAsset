package org.exotechasset.exotechasset.entity

public enum class FilterField : FilterFieldGetValue, ToStringInterface {
    DESCRIPTION {
        override public fun toString(): String = "Description"
        override public fun get(asset: Asset): Any? = asset.getDescription()
    },
    ID {
        override public fun toString(): String = "Id"
        override public fun get(asset: Asset): Any? = asset.getId()
    },
    STATUS {
        override public fun toString(): String = "Status"
        override public fun get(asset: Asset): Any? = asset.getStatus()
    },
    ASSIGNEE {
        override public fun toString(): String = "Assignee"
        override public fun get(asset: Asset): Any? = asset.getAssignee()
    },
    AUDIT_DATE {
        override public fun toString(): String = "AuditDate"
        override public fun get(asset: Asset): Any? = asset.getAuditDate()?.get()
    },
    LOCATION {
        override public fun toString(): String = "Location"
        override public fun get(asset:Asset): Any? = asset.getLocation()
    };
    // PARENT_ID,
    // CHILDREN,

    companion object {
        public fun of(fieldStr: String): FilterField =
                when (fieldStr) {
                    "Description" -> FilterField.DESCRIPTION
                    "Id" -> FilterField.ID
                    "Status" -> FilterField.STATUS
                    "Assignee" -> FilterField.ASSIGNEE
                    "AuditDate" -> FilterField.AUDIT_DATE
                    "Location" -> FilterField.LOCATION
                    else -> throw IllegalArgumentException("Unknown filter field")
                }
    }
}
