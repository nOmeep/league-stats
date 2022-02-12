package com.example.lolstats.util.cache

import androidx.core.view.isVisible
import com.example.lolstats.databinding.FragmentChampionsBinding

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(
        data: T?
    ) : Resource<T>(data)

    class Loading<T>(
        data: T?
    ) : Resource<T>(data)

    class Error<T>(
        throwable: Throwable,
        data: T?
    ) : Resource<T>(data, throwable)

    fun setLoadingOrError(binding: FragmentChampionsBinding) {
        binding.pbLoading.isVisible = this is Loading
        binding.tvLoadingText.isVisible = this is Loading
    }
}