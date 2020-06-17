package com.colagom.infiniterv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter<Cat : CarouselEntity>(
    private val clicked: (Cat) -> Unit
) : RecyclerView.Adapter<CarouselHolder<Cat>>() {
    private var items: List<Cat> = listOf()
    val actualItemCount
        get() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselHolder<Cat> =
        LayoutInflater.from(parent.context).inflate(R.layout.holder_carousel, parent, false)
            .let {
                CarouselHolder(it, clicked)
            }

    override fun getItemCount(): Int = if (items.isEmpty()) 0 else Integer.MAX_VALUE

    override fun onBindViewHolder(holder: CarouselHolder<Cat>, position: Int) {
        items[position % actualItemCount].let(holder::bind)
    }

    fun setItems(value: List<Cat>) {
        items = value
        notifyDataSetChanged()
    }
}