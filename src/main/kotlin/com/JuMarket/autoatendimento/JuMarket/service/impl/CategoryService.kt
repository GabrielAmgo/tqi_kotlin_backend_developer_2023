package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.repository.CategoryRepository
import com.JuMarket.autoatendimento.JuMarket.service.ICategoryService
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
): ICategoryService {
    override fun save(category: Category): Category =
        this.categoryRepository.save(category)

    override fun delete(id: Long) {
        this.categoryRepository.deleteById(id)
    }

    override fun findById(id: Long): Category =
        this.categoryRepository.findById(id).orElseThrow{
            throw RuntimeException ("Id $id not found")
        }

    override fun findAll(category: Category): List<Category> =
        this.categoryRepository.findAll()
}