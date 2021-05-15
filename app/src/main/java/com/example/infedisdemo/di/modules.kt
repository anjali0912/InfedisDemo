package com.example.infedisdemo.di

import com.example.infedisdemo.BuildConfig
import com.example.infedisdemo.data.api.ApiService
import com.example.infedisdemo.data.repository.DataRepository
import com.example.infedisdemo.data.repository.IDataRepository
import com.example.infedisdemo.ui.DataViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModules = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single(createOnStart = false) { get<Retrofit>().create(ApiService::class.java) }
}

val repositoryModules = module {
    single<IDataRepository> { DataRepository(get()) }
}

val viewModelModules = module {
    viewModel { DataViewModel(get()) }
}

