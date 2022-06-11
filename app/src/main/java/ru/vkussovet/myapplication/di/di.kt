package ru.vkussovet.myapplication.di


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vkussovet.myapplication.ui.oredering.OrderingViewModel
import ru.vkussovet.myapplication.data.api.VkussovetAPI
import ru.vkussovet.myapplication.data.repository.OrderingRepoImpl
import ru.vkussovet.myapplication.domain.repository.OrderingRepo
import ru.vkussovet.myapplication.domain.usecase.GetCategoryItemsUseCase
import ru.vkussovet.myapplication.domain.usecase.GetMenuItemsUseCase

const val API_URL: String = "https://vkus-sovet.ru"

val appModule = module {

    viewModel {
        OrderingViewModel(
            get(),
            get(),
            get()
        )
    }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BASIC

    single <VkussovetAPI>{

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        Retrofit.Builder()
            .client(client)
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VkussovetAPI::class.java)

    }

    single<OrderingRepo> {
        OrderingRepoImpl(get())
    }


    single {
        GetMenuItemsUseCase(get())
    }

    single {
        GetCategoryItemsUseCase(get())
    }



}
