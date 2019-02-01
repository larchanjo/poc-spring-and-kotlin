package com.sensedia.kotlin.infra.resources

import com.sensedia.kotlin.domain.services.GetWeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("weather")
class GetWeatherController(val getWeatherService: GetWeatherService) {

    @GetMapping
    fun getWeather(
            @RequestParam cityName: String,
            @RequestParam countryCode: String
    ) = getWeatherService.getWeather(cityName, countryCode)

}