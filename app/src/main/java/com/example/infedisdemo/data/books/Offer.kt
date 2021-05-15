package com.example.infedisdemo.data.books

data class Offer(
    val finskyOfferType: Int?= -1,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
)