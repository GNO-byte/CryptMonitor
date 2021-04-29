package com.gno.cryptmonitor.retrofit

data class Answer(
    val `data`: List<Data>,
    val status: Status
)

data class Data(
    val symbol: String,
    val name: String,
    val cmc_rank: Int,
    val circulating_supply: Float,
    val quote: Quote
)

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: Any,
    val notice: Any,
    val timestamp: String,
    val total_count: Int
)

data class Quote(
    val USD: USD
)

data class USD(
    val price: Double
)
