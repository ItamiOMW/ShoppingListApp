package com.example.shoppinglistapp.di

import android.app.Application
import com.example.shoppinglistapp.data.database.AppDatabase
import com.example.shoppinglistapp.data.database.ShopItemsDao
import com.example.shoppinglistapp.data.repository_impl.ShopListRepositoryImpl
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

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