package com.tarun.demoapplication.model

import com.google.gson.annotations.SerializedName

data class Cars(

	@field:SerializedName("Toyota")
	val toyota: Toyota? = null,

	@field:SerializedName("Suzuki")
	val suzuki: Suzuki? = null,

	@field:SerializedName("Tata")
	val tata: Tata? = null,

	@field:SerializedName("Honda")
	val honda: Honda? = null
)