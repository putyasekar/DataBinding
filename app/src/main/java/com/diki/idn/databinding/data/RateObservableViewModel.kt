package com.diki.idn.databinding.data

import androidx.databinding.Bindable
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.diki.idn.databinding.common.RateViewModel

class RateLiveDataViewModel : ViewModel() {
    private val _like = MutableLiveData(0)
    private val _dislike = MutableLiveData(0)

    val like: LiveData<Int> = _like
    val dislike: LiveData<Int> = _dislike

    val rating: LiveData<RateObservableViewModel.LikesNumber> = Transformations.map(_like) {
        when {
            it > 9 -> RateObservableViewModel.LikesNumber.FAMOUS
            it > 5 -> RateObservableViewModel.LikesNumber.POPULAR
            else -> RateObservableViewModel.LikesNumber.NORMAL
        }
    }

    fun onLike() {
        _like.value = (_like.value ?: 0) + 1
    }

    class RateObservableViewModel : RateViewModel() {
        private val likes = ObservableInt(0)

        enum class LikesNumber {
            NORMAL,
            POPULAR,
            FAMOUS
        }

        fun onLike() {
            likes.increment()
            notifyPropertyChanged(com.diki.idn.databinding.BR.popularity)
        }

        @Bindable
        fun getPopularity(): LikesNumber {
            return likes.get().let {
                when {
                    it > 9 -> LikesNumber.FAMOUS
                    it > 5 -> LikesNumber.POPULAR
                    else -> LikesNumber.NORMAL
                }
            }
        }
    }
}

private fun ObservableInt.increment() {
    set(get() + 1)
}
