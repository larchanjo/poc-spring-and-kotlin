package com.sensedia.kotlin.domain.model

data class GetWeatherResponse(val weather: List<Weather> = listOf())

data class Weather(val id: String, val main: String)