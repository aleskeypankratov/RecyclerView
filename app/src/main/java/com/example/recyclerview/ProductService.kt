package com.example.recyclerview

import com.github.javafaker.Faker

class ProductService {

    private var products = mutableListOf<Product>()
    private val faker: Faker = Faker.instance()

    init {
        IMAGES.shuffle()
        products = (0..20).map {
            Product(
                id = it.toString(),
                title = faker.food().dish(),
                category = "Food",
                preview = IMAGES[it % IMAGES.size]
            )
        }.toMutableList()
    }

    fun addProduct() {
        products.add(
            Product(
                id = products.size.toString(),
                title = faker.food().dish(),
                category = "Food",
                preview = IMAGES[(0..<IMAGES.size).random()]
            )
        )
    }

    fun getProduct(): List<Product> {
        return products
    }

    companion object {
        private val IMAGES = mutableListOf(
            "https://w7.pngwing.com/pngs/576/68/png-transparent-fork-illustration-fast-food-cafe-breakfast-restaurant-food-icon-food-text-fast-food-restaurant-thumbnail.png",
            "https://xn--63-6kc4be0fbz.xn--p1ai/upload/iblock/362/3624affa06c20d263029b6a52dcbf850.png",
            "https://img2.freepng.ru/20180510/thw/kisspng-pizza-buffet-taco-tableware-italian-cuisine-5af44f11037478.0438420215259604650142.jpg",
            "https://w7.pngwing.com/pngs/365/661/png-transparent-cafeteria-computer-icons-restaurant-food-hotel.png",
            "https://static.tildacdn.com/tild3639-3830-4239-b338-363064383132/photo.png"
        )
    }
}