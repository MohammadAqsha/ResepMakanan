package com.D121211018.Makanan.data.response

data class Source(
    val annotations: Annotations,
    val measures: List<String>,
    val name: String,
    val substitutions: List<Any>
)