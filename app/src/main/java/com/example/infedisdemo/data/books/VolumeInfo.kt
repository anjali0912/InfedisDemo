package com.example.infedisdemo.data.books

data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>?=null,
    val averageRating: Int? = -1,
    val canonicalVolumeLink: String? = "",
    val categories: List<String>?=null,
    val contentVersion: String? = "",
    val description: String? = "",
    val imageLinks: ImageLinks?=null,
    val industryIdentifiers: List<IndustryIdentifier>?= null,
    val infoLink: String? = "",
    val language: String? = "",
    val maturityRating: String? = "",
    val pageCount: Int?= -1,
    val panelizationSummary: PanelizationSummary?= null,
    val previewLink: String? = "",
    val printType: String? = "",
    val publishedDate: String? = "",
    val publisher: String? = "",
    val ratingsCount: Int? = -1,
    val readingModes: ReadingModes,
    val subtitle: String? = "",
    val title: String? = ""
)