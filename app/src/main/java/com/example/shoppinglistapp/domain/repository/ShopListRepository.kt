package com.example.shoppinglistapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.domain.model.ShopItem

interface ShopListRepository {

    suspend fun addShopItem(item: ShopItem)

    suspend fun deleteShopItem(item: ShopItem)

    suspend fun getShopItem(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

    suspend fun editShopItem(item: ShopItem)
}