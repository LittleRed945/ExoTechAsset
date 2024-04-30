package org.exotechasset.exotechasset.entity

enum class AssetStatus : ToStringInterface {
    DEPLOYABLE {
        override public fun toString(): String = "Deployable"
    },
    PENDING {
        override public fun toString(): String = "Pending"
    },
    DEPLOYED {
        override public fun toString(): String = "Deployed"
    },
    UNDEPLOYABLE {
        override public fun toString(): String = "Undeployable"
    }
}
