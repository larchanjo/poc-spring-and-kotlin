package com.sensedia.kotlin.domain

import com.sensedia.kotlin.domain.model.WeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.web.client.RestTemplate

class OpenWeatherApi(val apiKey: String, val restTemplate: RestTemplate) {

    val log = LoggerFactory.getLogger(this.javaClass)

    fun getWeather(cityName: String, countryCode: String): WeatherResponse? {
        log.info("Getting weather form $cityName and $countryCode")
        val weatherUri = "http://api.openweathermap.org/data/2.5/weather?q=$cityName,$countryCode&appid=$apiKey"
        log.info("Requesting $weatherUri")
        return restTemplate.getForObject(weatherUri, WeatherResponse::class.java)
    }

}