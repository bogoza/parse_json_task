package com.example.jsonparsetask.data_model

import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class Input(
    val field_id: Int,
    val hint: String,
    val field_type: String,
    val keyboard: String,
    val required: Boolean,
    val is_active: Boolean,
    val icon: String
)
@JsonClass(generateAdapter = true)
data class InputList(
    val inputs: List<List<Input>>
)
enum class FieldType{
    INPUT,
    CHOOSER
}
