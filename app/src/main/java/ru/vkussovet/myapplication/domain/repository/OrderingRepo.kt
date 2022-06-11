package ru.vkussovet.myapplication.domain.repository



import ru.vkussovet.myapplication.domain.model.CategoryItem
import ru.vkussovet.myapplication.domain.model.MenuItem

interface OrderingRepo {

    suspend fun getCategories(): List<CategoryItem>
    suspend fun getMenuItems(menuID: Int): List<MenuItem>

}