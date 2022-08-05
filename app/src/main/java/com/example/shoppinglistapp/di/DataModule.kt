package com.example.shoppinglistapp.di

import android.app.Application
import com.example.shoppinglistapp.data.AppDatabase
import com.example.shoppinglistapp.data.ShopItemsDao
import com.example.shoppinglistapp.data.ShopListRepositoryImpl
import com.example.shoppinglistapp.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindShopRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @AppScope
        @Provides
        fun provideShopDao(
            application: Application
        ): ShopItemsDao {
            return AppDatabase.getInstance(application).getItemDao()
        }
    }
}