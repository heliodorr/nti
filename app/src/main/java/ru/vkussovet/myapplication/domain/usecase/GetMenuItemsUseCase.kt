package ru.vkussovet.myapplication.domain.usecase

import ru.vkussovet.myapplication.domain.model.MenuItem
import ru.vkussovet.myapplication.domain.repository.OrderingRepo

class GetMenuItemsUseCase(
    val repo: OrderingRepo
) {
    suspend fun execute(menuId: Int): List<MenuItem> {
        return repo.getMenuItems(menuId)
    }

}