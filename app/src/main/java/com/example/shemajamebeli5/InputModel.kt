package com.example.shemajamebeli5

import com.google.gson.annotations.SerializedName

data class InputModel(
    @SerializedName("field_id")
    val id: Int,
    @SerializedName("field_type")
    val fieldType: String,
    val hint: String,
    val icon: String,
    @SerializedName("is_active")
    val active: Boolean,
    val keyboard: String? = "",
    val required: Boolean
)
