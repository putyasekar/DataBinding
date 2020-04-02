package com.diki.idn.databinding.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.diki.idn.databinding.R
import com.diki.idn.databinding.data.RateLiveDataViewModel

object BindingAdapter {
    @BindingAdapter("app:ratingIcon")
    @JvmStatic
    fun ratingIcon(
        imageView: ImageView,
        rating: RateLiveDataViewModel.RateObservableViewModel.LikesNumber
    ) {
        val color = getAssociatedColor(rating, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawablePopularity(rating, imageView.context))
    }

    private fun getDrawablePopularity(
        rating: RateLiveDataViewModel.RateObservableViewModel.LikesNumber,
        context: Context
    ): Drawable? {
        return when (rating) {
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.like)
            }
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.like)
            }
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.FAMOUS -> {
                ContextCompat.getDrawable(context, R.drawable.like)
            }
        }
    }

    private fun getAssociatedColor(
        rating: RateLiveDataViewModel.RateObservableViewModel.LikesNumber,
        context: Context
    ): Int {
        return when (rating) {
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.NORMAL -> ContextCompat.getColor(
                context,
                R.color.normal
            )
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.POPULAR -> ContextCompat.getColor(
                context,
                R.color.popular
            )
            RateLiveDataViewModel.RateObservableViewModel.LikesNumber.FAMOUS -> ContextCompat.getColor(
                context,
                R.color.famous
            )
        }
    }
}