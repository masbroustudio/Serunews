package com.serunews.newsapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.serunews.core.domain.model.IndoNews
import com.serunews.newsapp.R
import com.serunews.newsapp.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val detailIndoNews = intent.getParcelableExtra<IndoNews>(EXTRA_DATA)

        showDetailNewsIndo(detailIndoNews)
    }

    private fun showDetailNewsIndo(detailIndoNews: IndoNews?) {
        detailIndoNews?.let {
            supportActionBar?.title = detailIndoNews.judul
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            binding.content.tvDateDetail.text = detailIndoNews.rilisberita
            binding.content.tvDetailTitle.text = detailIndoNews.judul
            binding.content.tvDetailDescription.text = detailIndoNews.headline
            binding.content.tvDetailCategory.text = detailIndoNews.kategori
            binding.content.tvDetailNewsbadge.text = detailIndoNews.news_badge

            Glide.with(this@DetailActivity)
                .load(detailIndoNews.foto)
                .into(binding.ivDetailImage)

            var statusFavorite = detailIndoNews.isFavorite

            setStatusFavorite(statusFavorite)
            
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteNewsIndo(detailIndoNews, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_24
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_border_24
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}