package com.example.shemajamebeli5

import com.squareup.moshi.Json

data class InputModel(
    @Json(name = "field_id")
    val id: Int,
    @Json(name = "field_type")
    val fieldType: String,
    val hint: String,
    val icon: String,
    @Json(name = "is_active")
    val active: Boolean,
    val keyboard: String,
    val required: String
)
