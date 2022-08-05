package com.example.shoppinglistapp.domain.usecases

import com.example.shoppinglistapp.domain.model.ShopItem
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor (private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(id: Int): ShopItem {
        return shopListRepository.getShopItem(id)
    }
}