package com.sensedia.kotlin.domain

import com.sensedia.kotlin.domain.model.Weather
import org.slf4j.LoggerFactory
import org.springframework.web.client.RestTemplate

class OpenWeatherApi(val apiKey: String, val restTemplate: RestTemplate) {

    val log = LoggerFactory.getLogger(this.javaClass)
    val domain = "http://api.openweathermap.org"

    fun getWeather(cityName: String, countryCode: String): Weather? {
        log.info("Getting weather form $cityName and $countryCode")
        val weatherUri = "$domain/data/2.5/weather?q=$cityName,$countryCode&appid=$apiKey&units=metric"
        log.info("Requesting $weatherUri")
        return restTemplate.getForObject(weatherUri, Weather::class.java)
    }

}