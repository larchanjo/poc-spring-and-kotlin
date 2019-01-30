package com.sensedia.kotlin.domain

import org.springframework.web.client.RestTemplate

class OpenWeatherApi(val apiKey: String, val restTemplate: RestTemplate) {

    // List of cities http://bulk.openweathermap.org/sample/city.list.json.gz
    val cityName = "Estado de São Paulo"
    val countryCode = "BR"
    val forecastUri = "http://api.openweathermap.org/data/2.5/weather?q={CITY},{COUNTRY}&appid={APIKEY}";

}