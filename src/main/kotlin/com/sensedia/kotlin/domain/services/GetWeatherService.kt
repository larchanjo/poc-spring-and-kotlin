package com.sensedia.kotlin.domain.services

import com.sensedia.kotlin.domain.OpenWeatherApi
import org.springframework.stereotype.Service

@Service
class GetWeatherService(val openWeatherApi: OpenWeatherApi) {

    fun getWeather(cityName: String, countryCode: String) = openWeatherApi.getWeather(cityName, countryCode)

}