package com.example.shoppinglistapp.presentation.main_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.databinding.ItemShopDisabledBinding
import com.example.shoppinglistapp.databinding.ItemShopEnabledBinding
import com.example.shoppinglistapp.domain.model.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopListViewHolder>(ShopItemDiffCallback()) {

    var onLongShopItemClick: ((ShopItem) -> Unit)? = null
    var onShopItemClick: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layoutId = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown viewType: $viewType")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return ShopListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val item = getItem(position)
        val binding = holder.binding
        binding.root.setOnLongClickListener {
            onLongShopItemClick?.invoke(item)
            true
        }
        binding.root.setOnClickListener {
            onShopItemClick?.invoke(item)
        }
        when (binding) {
            is ItemShopEnabledBinding -> {
                binding.shopItem = item
            }
            is ItemShopDisabledBinding -> {
                binding.shopItem = item
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 2
        const val MAX_POOL_SIZE = 10
    }
}