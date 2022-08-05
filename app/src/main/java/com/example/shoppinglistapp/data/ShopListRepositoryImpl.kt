package com.example.shoppinglistapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shoppinglistapp.domain.ShopItem
import com.example.shoppinglistapp.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor (
    private val shopItemsDao: ShopItemsDao,
    private val mapper: ShopItemMapper
) : ShopListRepository {


    override suspend fun addShopItem(item: ShopItem) {
        shopItemsDao.addShopItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun deleteShopItem(item: ShopItem) {
        shopItemsDao.deleteShopItem(item.id)
    }

    override suspend fun getShopItem(id: Int): ShopItem {
        val dbModel = shopItemsDao.getShopItem(id)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(shopItemsDao.getShopList()) {
            mapper.mapListDbModelToListEntity(it)
        }

    override suspend fun editShopItem(item: ShopItem) {
        shopItemsDao.addShopItem(mapper.mapEntityToDbModel(item))
    }

}