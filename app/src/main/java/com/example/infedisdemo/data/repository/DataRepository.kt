package com.example.infedisdemo.data.repository

import com.example.infedisdemo.data.Result
import com.example.infedisdemo.data.api.ApiService
import com.example.infedisdemo.data.books.Item
import com.example.infedisdemo.data.news.Article

class DataRepository(private val apiService: ApiService) : IDataRepository {

    companion object {
        private val TAG = DataRepository::class.java.simpleName
    }

    override suspend fun fetchBitcoinRemoteNews(): Result<List<Article>> {
        return try {
            val response = apiService.fetchBitcoinNews()
            if (response.isSuccessful) {
                Result.Success(response.body()?.articles ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchBusinessRemoteNews(): Result<List<Article>> {
        return try {
            val response = apiService.fetchBusinessNews()
            if (response.isSuccessful) {
                Result.Success(response.body()?.articles ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchAppleRemoteNews(): Result<List<Article>> {
        return try {
            val response = apiService.fetchAppleNews()
            if (response.isSuccessful) {
                Result.Success(response.body()?.articles ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchTechCrunchRemoteNews(): Result<List<Article>> {
        return try {
            val response = apiService.fetchTechCrunchNews()
            if (response.isSuccessful) {
                Result.Success(response.body()?.articles ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchWallStreetRemoteNews(): Result<List<Article>> {
        return try {
            val response = apiService.fetchWallStreetNews()
            if (response.isSuccessful) {
                Result.Success(response.body()?.articles ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchBooksData(): Result<List<Item>> {
        return try {
            val response = apiService.fetchBooksData()
            if (response.isSuccessful) {
                Result.Success(response.body()?.items ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}

