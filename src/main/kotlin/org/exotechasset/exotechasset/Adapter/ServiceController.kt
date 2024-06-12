package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.usecase.AssetHandler
import org.exotechasset.exotechasset.usecase.FilterHandler
import org.exotechasset.exotechasset.usecase.ExporterImporterHandler


object ServiceController {
    public val assetHandler: AssetHandler = AssetHandler()
    public val filterHandler: FilterHandler = FilterHandler(assetHandler)
    public val exporterImporterHandler: ExporterImporterHandler = ExporterImporterHandler(assetHandler)
}
