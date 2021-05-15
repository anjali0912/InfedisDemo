package com.example.infedisdemo.data.api

import com.example.infedisdemo.BuildConfig
import com.example.infedisdemo.data.books.BooksModel
import com.example.infedisdemo.data.news.NewsModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * ApiService is responsible to define end points and its responses.
 */
interface ApiService {

    @GET("everything?q=bitcoin&from=2021-04-15&sortBy=publishedAt&apiKey=${BuildConfig.NEW_API_KEY}")
    suspend fun fetchBitcoinNews(): Response<NewsModel>

    @GET("top-headlines?country=us&category=business&apiKey=${BuildConfig.NEW_API_KEY}")
    suspend fun fetchBusinessNews(): Response<NewsModel>

    @GET("everything?q=apple&from=2021-05-14&to=2021-05-14&sortBy=popularity&apiKey=${BuildConfig.NEW_API_KEY}")
    suspend fun fetchAppleNews(): Response<NewsModel>

    @GET("top-headlines?sources=techcrunch&apiKey=${BuildConfig.NEW_API_KEY}")
    suspend fun fetchTechCrunchNews(): Response<NewsModel>

    @GET("everything?domains=wsj.com&apiKey=${BuildConfig.NEW_API_KEY}")
    suspend fun fetchWallStreetNews(): Response<NewsModel>

    @GET("https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&apiKey=${BuildConfig.BOOK_API_KEY}")
    suspend fun fetchBooksData(): Response<BooksModel>
}