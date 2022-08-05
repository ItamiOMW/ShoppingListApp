package com.example.shoppinglistapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.domain.model.ShopItem
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopListUseCase @Inject constructor (private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}