package ru.vkussovet.myapplication.domain.usecase

import ru.vkussovet.myapplication.domain.model.CategoryItem
import ru.vkussovet.myapplication.domain.repository.OrderingRepo

class GetCategoryItemsUseCase(
    val repo: OrderingRepo
) {

    suspend fun execute(): List<CategoryItem> {
        return repo.getCategories()
    }

}