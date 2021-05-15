package com.example.infedisdemo.data.repository

import com.example.infedisdemo.data.Result
import com.example.infedisdemo.data.books.Item
import com.example.infedisdemo.data.news.Article


interface IDataRepository {
    /**
     * Fetch the bitcoin data from the remote server.
     */
    suspend fun fetchBitcoinRemoteNews(): Result<List<Article>>

    /**
     * Fetch the buiness data from the remote server.
     */
    suspend fun fetchBusinessRemoteNews(): Result<List<Article>>

    /**
     * Fetch the apple data from the remote server.
     */
    suspend fun fetchAppleRemoteNews(): Result<List<Article>>

    /**
     * Fetch the tech crunch data from the remote server.
     */
    suspend fun fetchTechCrunchRemoteNews(): Result<List<Article>>

    /**
     * Fetch the wall street data from the remote server.
     */
    suspend fun fetchWallStreetRemoteNews(): Result<List<Article>>

    /**
     * Fetch the books data from the remote server.
     */
    suspend fun fetchBooksData(): Result<List<Item>>
}