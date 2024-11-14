package org.exotechasset.exotechasset.adapter

import org.exotechasset.exotechasset.Usecase.AssetHandler
import org.exotechasset.exotechasset.Usecase.FilterHandler
import org.exotechasset.exotechasset.Usecase.ExporterImporterHandler


object ServiceController {
    public val assetHandler: AssetHandler = AssetHandler()
    public val filterHandler: FilterHandler = FilterHandler(assetHandler)
    public val exporterImporterHandler: ExporterImporterHandler = ExporterImporterHandler(assetHandler)
}
