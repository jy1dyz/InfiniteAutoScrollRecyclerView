package com.colagom.infiniterv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.holder_carousel.view.*

class CarouselHolder<Cat : CarouselEntity>(
    itemView: View,
    private val clicked: (Cat) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val iv by lazy {
        itemView.ken_burns_view
    }

    fun bind(data: Cat) {
        Glide.with(itemView)
            .load(data.imgUrl)
            .into(iv)

        itemView.setOnClickListener {
            clicked(data)
        }
    }
}
