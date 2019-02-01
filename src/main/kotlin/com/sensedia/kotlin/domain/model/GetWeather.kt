package com.sensedia.kotlin.domain.model

data class Weather(val main: Main)

data class Main(val temp: Double, val pressure: Double, val humidity: Double)