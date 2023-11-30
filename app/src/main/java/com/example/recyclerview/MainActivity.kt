package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private lateinit var button: Button
    private val productService: ProductService = ProductService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvProduct.layoutManager = layoutManager
        binding.rvProduct.adapter = adapter
        button = binding.btnAdd

        var products = productService.getProduct()
        adapter.submitList(products)

        button.setOnClickListener {
            addProductAndNotify()
        }
    }

    private fun addProductAndNotify() {
        productService.addProduct()
        adapter.submitList(productService.getProduct())
        binding.rvProduct.scrollToPosition(adapter.itemCount - 1)
    }
}