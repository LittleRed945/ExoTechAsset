package org.exotechasset.exotechasset.entity

import org.exotechasset.exotechasset.entity.AssetStatus.*

// TODO: record into changelog

class CompositeAsset(
        id: String,
        status: AssetStatus = DEPLOYABLE,
        assignee: String? = null,
        auditDate: Date? = null,
        location: Location? = null,
        changelog: Changelog = Changelog()
) : Asset(id, status, assignee, auditDate, location, changelog) {
    private var children: MutableMap<String, Asset> = mutableMapOf()

    public override fun getChildrenIdList(): List<String> = this.children.keys.toList()
    public override fun getChildren(): List<Asset> = this.children.values.toList()

    public override fun hasChildren(): Boolean = (this.children.isEmpty() == false)

    public override fun add(asset: Asset) {
        val newAssetId: String = asset.getId()
        this.children.put(newAssetId, asset)

        check(asset == this.children.get(newAssetId))
    }

    public override fun remove(id: String) {
        require(this.children.containsKey(id))

        this.children.remove(id)

        check(this.children.containsKey(id) == false)
    }

    public override fun remove(asset: Asset) {
        val id = asset.getId()
        this.remove(id)
    }

    public override fun modify(asset: Asset) {
        super.modify(asset)
        val newChildren = asset.getChildren()
        val newChildrenMap = newChildren.map { it.getId() to it }.toMap().toMutableMap()
        this.children = newChildrenMap

        check(this.getChildrenIdList().equals(asset.getChildrenIdList()))
        check(this.getChildren().equals(asset.getChildren()))
    }
}
