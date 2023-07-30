package com.JuMarket.autoatendimento.JuMarket.controller

import com.JuMarket.autoatendimento.JuMarket.dto.*
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.service.impl.CartService
import jakarta.persistence.Id
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(
    private val cartService: CartService
) {

    @PostMapping("/add")
    fun addItem(@RequestBody request: CartItemDto): String {
        cartService.addItem(request.cartId,request.productId, request.amount)
    return "Item ${request.productId} added to your cart!"
    }

    @DeleteMapping("/remove")
    fun removeItem(@RequestBody request: CartItemDto): String{
        cartService.removeItem(request.productId, request.amount)
    return "Item ${request.productId} removed from your cart!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : CartView {
        val cart: Cart = this.cartService.findById(id)
        return CartView(cart)
    }
    @GetMapping
    fun displayCart(): Pair<Long?, List<CartItemInfoDto>> {
        return cartService.displayCart()
    }

    @DeleteMapping("/clear")
    fun clearCart(): String{
        cartService.clearCart()
    return "All items has been removed from your cart!"
    }



}