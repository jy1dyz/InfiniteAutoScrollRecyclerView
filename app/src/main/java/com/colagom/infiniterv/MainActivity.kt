package com.colagom.infiniterv

import android.os.Bundle
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dummyNotices = listOf(
        Cat("https://wikiway.com/upload/hl-photo/8c0/3d1/vankuver_163.jpg"),
        Cat("https://wikiway.com/upload/hl-photo/048/eb6/vankuver_165.jpg"),
        Cat("https://wikiway.com/upload/hl-photo/96a/2d3/vankuver_162.jpg"),
        Cat("https://wikiway.com/upload/resize_cache/hl-photo/943/ed0/1024_800_1/vankuver_146.jpg"),
        Cat("https://wikiway.com/upload/hl-photo/0a0/0b9/vankuver_138.jpg")
    )

    lateinit var autoScrollRecyclerView: AutoScrollableRecyclerView

    private val carouselAdapter by lazy {
        CarouselAdapter(::catClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoScrollRecyclerView = findViewById(R.id.rv_cat)

        rv_cat.run {
            PagerSnapHelper().attachToRecyclerView(this)
            autoScrollRecyclerView.adapter = carouselAdapter.apply {
                setItems(dummyNotices)
            }
            autoScrollRecyclerView.
            resumeAutoScroll()
        }
    }

    private fun catClicked(cat: Cat) {
       // tv.text = "clicked ${cat.linkUrl}"
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }
}

data class Cat(
    override val imgUrl: String
  //  val linkUrl: String
) : CarouselEntity()
