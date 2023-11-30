package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recyclerview.databinding.ProductItemBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class ProductViewHolder(private val itemBinding: ProductItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(product: Product) = with(itemBinding) {
            textTitle.text = product.title
            textCategory.text = product.category

            if (product.preview.isNotBlank()) {
                imageView.load(product.preview)
                {
                    crossfade(true)
                    placeholder(R.drawable.base)
                    error(R.drawable.base)
                }
            } else {
                imageView.setImageResource(R.drawable.base)
            }
        }
    }
    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(products: List<Product>) {
        differ.submitList(products)
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}

