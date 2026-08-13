package com.example.epamtest.data.repository

sealed interface RefreshResult {

    data object Success : RefreshResult

    data class Error(
        val exception: Throwable
    ) : RefreshResult
}