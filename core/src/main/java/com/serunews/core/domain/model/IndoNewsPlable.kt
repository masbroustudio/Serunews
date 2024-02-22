package com.serunews.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndoNews(
    val aksesurl: String,
    val judul: String,
    val foto: String,
    val headline: String,
    val kategori: String,
    val rilisberita: String,
    val news_badge: String,
    val isFavorite: Boolean
) : Parcelable