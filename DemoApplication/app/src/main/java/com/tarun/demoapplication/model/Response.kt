package com.tarun.demoapplication.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("cars")
	val cars: Cars? = null,

	@field:SerializedName("celebrities")
	val celebrities: Celebrities? = null
)