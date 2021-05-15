package com.example.infedisdemo.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infedisdemo.data.news.Article
import com.example.infedisdemo.data.repository.IDataRepository
import com.example.infedisdemo.data.Result
import com.example.infedisdemo.data.books.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataViewModel(private val repository: IDataRepository) : ViewModel() {

    private val mutableBitcoinNews = MutableLiveData<List<Article>>()
    val resultBitcoinNews: LiveData<List<Article>>
        get() = mutableBitcoinNews

    private val mutableBusinessNews = MutableLiveData<List<Article>>()
    val resultBusinessNews: LiveData<List<Article>>
        get() = mutableBusinessNews

    private val mutableAppleNews = MutableLiveData<List<Article>>()
    val resultAppleNews: LiveData<List<Article>>
        get() = mutableAppleNews

    private val mutableTechCrunchNews = MutableLiveData<List<Article>>()
    val resultTechCrunchNews: LiveData<List<Article>>
        get() = mutableTechCrunchNews

    private val mutableWallStreetNews = MutableLiveData<List<Article>>()
    val resultWallStreetNews: LiveData<List<Article>>
        get() = mutableWallStreetNews

    private val mutableBooks = MutableLiveData<List<Item>>()
    val resultBooks: LiveData<List<Item>>
        get() = mutableBooks

    companion object {
        private val TAG = DataViewModel::class.java.simpleName
    }

    init {
        fetchBitcoinNewsFromRemote()
        fetchBusinessNewsFromRemote()
        fetchAppleNewsFromRemote()
        fetchTechCrunchNewsFromRemote()
        fetchWallStreetNewsFromRemote()
        fetchBooksFromRemote()
    }

    /**
     * Gets the bitcoin data from the remote server.
     */
    private fun fetchBitcoinNewsFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchBitcoin =
                    withContext(Dispatchers.IO) { repository.fetchBitcoinRemoteNews() }) {
                    is Result.Success -> {
                        val bitcoin = fetchBitcoin.data
                        mutableBitcoinNews.value = bitcoin
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }


    /**
     * Gets the business data from the remote server.
     */
    private fun fetchBusinessNewsFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchBusinesscoin =
                    withContext(Dispatchers.IO) { repository.fetchBusinessRemoteNews() }) {
                    is Result.Success -> {
                        val business = fetchBusinesscoin.data
                        mutableBusinessNews.value = business
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }


    /**
     * Gets the apple data from the remote server.
     */
    private fun fetchAppleNewsFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchApple =
                    withContext(Dispatchers.IO) { repository.fetchAppleRemoteNews() }) {
                    is Result.Success -> {
                        val apple = fetchApple.data
                        mutableAppleNews.value = apple
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }



    /**
     * Gets the tech crunch data from the remote server.
     */
    private fun fetchTechCrunchNewsFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchTechCrunch =
                    withContext(Dispatchers.IO) { repository.fetchTechCrunchRemoteNews() }) {
                    is Result.Success -> {
                        val techCrunch = fetchTechCrunch.data
                        mutableTechCrunchNews.value = techCrunch
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }

    /**
     * Gets the wall street data from the remote server.
     */
    private fun fetchWallStreetNewsFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchWallStreet =
                    withContext(Dispatchers.IO) { repository.fetchWallStreetRemoteNews() }) {
                    is Result.Success -> {
                        val wallstreet = fetchWallStreet.data
                        mutableWallStreetNews.value = wallstreet
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }


    /**
     * Gets the books data from the remote server.
     */
    private fun fetchBooksFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchBook =
                    withContext(Dispatchers.IO) { repository.fetchBooksData() }) {
                    is Result.Success -> {
                        val books = fetchBook.data
                        mutableBooks.value = books
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }
}