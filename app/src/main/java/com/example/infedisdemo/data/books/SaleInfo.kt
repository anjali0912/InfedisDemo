package com.example.infedisdemo.data.books

data class SaleInfo(
    val buyLink: String?= "",
    val country: String?= "",
    val isEbook: Boolean?= false,
    val listPrice: ListPrice?=null,
    val offers: List<Offer>? = null,
    val retailPrice: RetailPriceX?=null,
    val saleability: String?= ""
)