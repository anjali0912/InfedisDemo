package com.example.infedisdemo.data.books

data class AccessInfo(
    val accessViewStatus: String?= "",
    val country: String?= "",
    val embeddable: Boolean?= false,
    val epub: Epub,
    val pdf: Pdf,
    val publicDomain: Boolean?= false,
    val quoteSharingAllowed: Boolean?= false,
    val textToSpeechPermission: String?= "",
    val viewability: String?= "",
    val webReaderLink: String?= ""
)