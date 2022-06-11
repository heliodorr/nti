package ru.vkussovet.myapplication.data.repository

import ru.vkussovet.myapplication.data.api.VkussovetAPI

import ru.vkussovet.myapplication.domain.model.CategoryItem
import ru.vkussovet.myapplication.domain.model.MenuItem
import ru.vkussovet.myapplication.domain.repository.OrderingRepo

class OrderingRepoImpl(
    val api: VkussovetAPI
): OrderingRepo {



    override suspend fun getCategories(): List<CategoryItem> {
        val data = api.getCategories()
       return data.categoryItemList?.map { it.toCategoryItem() } ?: emptyList()
    }




    override suspend fun getMenuItems(menuID: Int): List<MenuItem> {
        val data = api.getMenuItems(menuID)
        return data.menuList?.map { it.toMenuItem() } ?: emptyList()

    }





}