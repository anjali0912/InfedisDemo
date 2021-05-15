package com.example.infedisdemo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.infedisdemo.R
import com.example.infedisdemo.data.books.Item
import com.example.infedisdemo.data.books.RetailPrice

/**
 * Mapper provides modified data to the view.
 */
object Mapper {

    @JvmStatic
    fun getUpdatedDate(eventDate: String?): String? {
        return eventDate?.let { DateUtil.getStandardTime(it) }
    }

    @JvmStatic
    fun getImageUrl(imageUrl: String?): String? {
        return imageUrl?.replace("http","https")
    }

    @JvmStatic
    fun getRetailPrice(item: Item): String? {
        var retailPrice : String? = ""
        var amount = item.saleInfo.retailPrice?.amount ?: 0
        var currency = item.saleInfo.retailPrice?.currencyCode ?: ""
        retailPrice =  amount.toString() +" "+ currency
        return retailPrice
    }

    @JvmStatic
    @BindingAdapter("app:profileImage")
    fun loadImage(view: ImageView, imageUrl: String?) {
        val drawable = R.mipmap.ic_launcher_round
        Glide.with(view.context)
            .load(imageUrl).apply(RequestOptions().placeholder(drawable).fitCenter())
            .into(view)
    }
}