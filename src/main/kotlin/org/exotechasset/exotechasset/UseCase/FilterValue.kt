package org.exotechasset.exotechasset.usecase

import org.exotechasset.exotechasset.entity.Asset
import org.exotechasset.exotechasset.entity.FilterField

data class FilterValue(val by: FilterField) {
    public fun get(asset: Asset): Any? =
            when (this.by) {
                FilterField.DESCRIPTION -> asset.getDescription()
                FilterField.ID -> asset.getId()
                FilterField.STATUS -> asset.getStatus()
                FilterField.ASSIGNEE -> asset.getAssignee()
                FilterField.AUDIT_DATE -> asset.getAuditDate()
                FilterField.LOCATION -> asset.getLocation()
                // FilterField.CHANGELOG -> asset.getChangelog()
                // FilterField.PARENT_ID -> asset.
                // FilterField.CHILDREN -> asset.getChildren()
            }

    public fun toNumber(asset: Asset): Long? =
            when (this.by) {
                FilterField.DESCRIPTION -> null
                FilterField.ID -> null
                FilterField.STATUS -> null
                FilterField.ASSIGNEE -> null
                FilterField.AUDIT_DATE -> asset.getAuditDate()?.get()
                FilterField.LOCATION -> null
                // FilterField.CHANGELOG -> null
                // FilterField.PARENT_ID -> asset.
                // FilterField.CHILDREN -> null
            }

    public fun toString(asset: Asset): String? =
            when (this.by) {
                FilterField.DESCRIPTION -> asset.getDescription()
                FilterField.ID -> asset.getId()
                FilterField.STATUS -> asset.getStatus().toString()
                FilterField.ASSIGNEE -> asset.getAssignee()
                FilterField.AUDIT_DATE -> asset.getAuditDate()?.toString()
                FilterField.LOCATION -> asset.getLocation()?.get()
                // FilterField.CHANGELOG ->
                // FilterField.PARENT_ID -> asset.
                // FilterField.CHILDREN -> asset.getChildren()
            }
}
