package com.app.domain.exception

import androidx.annotation.StringRes

data class APIException(
    @StringRes
    val genericError: Int? = null,
    val apiError: String? = null
) : Throwable()