package com.tarun.demoapplication.model

import com.google.gson.annotations.SerializedName

data class Jaime(

	@field:SerializedName("popularity")
	val popularity: Int? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("age")
	val age: Int? = null,

	@field:SerializedName("height")
	val height: String? = null
)