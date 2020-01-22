package com.tarun.demoapplication.model

import com.google.gson.annotations.SerializedName

data class Celebrities(

	@field:SerializedName("Jon Snow")
	val jonSnow: JonSnow? = null,

	@field:SerializedName("Cersie")
	val cersie: Cersie? = null,

	@field:SerializedName("Jaime")
	val jaime: Jaime? = null,

	@field:SerializedName("Tormund")
	val tormund: Tormund? = null,

	@field:SerializedName("Aarya")
	val aarya: Aarya? = null,

	@field:SerializedName("Tyrion")
	val tyrion: Tyrion? = null,

	@field:SerializedName("Daenerys")
	val daenerys: Daenerys? = null,

	@field:SerializedName("Samwell")
	val samwell: Samwell? = null
)