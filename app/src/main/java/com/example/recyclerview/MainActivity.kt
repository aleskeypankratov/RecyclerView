package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvProduct.layoutManager = layoutManager
        binding.rvProduct.adapter = adapter

        var products = mutableListOf(
            Product("1", "Стол", "Мебель", ""),
            Product("2", "Стул", "Мебель", ""),
            Product("3", "Шкаф", "Мебель", ""),
            Product("4", "Тумба", "Мебель", ""),
            Product("5", "Вешалка", "Мебель", ""),
            Product("6", "Полка", "Мебель", ""),
            Product("7", "Диван", "Мебель", ""),
            Product("8", "Кровать", "Мебель", ""),
            Product("9", "Ковер", "Мебель", ""),
            Product("10", "Зеркало", "Мебель", ""),
            Product("11", "Лампа", "Мебель", ""),
        )

        adapter.submitList(products)

    }
}