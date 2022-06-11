package ru.vkussovet.myapplication.data.api

import retrofit2.http.POST
import retrofit2.http.Query
import ru.vkussovet.myapplication.data.dto.CategoryDtoHolder
import ru.vkussovet.myapplication.data.dto.MenuItemDtoHolder

interface VkussovetAPI {

    @POST("/api/getMenu.php")
    suspend fun getCategories(): CategoryDtoHolder

    @POST("/api/getSubMenu.php")
    suspend fun getMenuItems(@Query("menuID") menuID: Int): MenuItemDtoHolder

}

