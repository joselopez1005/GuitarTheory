package com.example.guitartheory.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DrawableStringPair(
	@DrawableRes val drawable: Int,
	@StringRes val text: Int
)