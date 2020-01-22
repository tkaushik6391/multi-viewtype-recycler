package com.tarun.demoapplication.model

import com.google.gson.annotations.SerializedName

data class ResultDto(

	@field:SerializedName("popularity")
	var popularity: Int? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("photo")
	var photo: String? = null,

	@field:SerializedName("type")
	var type: Int? = null,

	@field:SerializedName("age")
	var age: Int? = null,

	@field:SerializedName("height")
	var height: String? = null
)