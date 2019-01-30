package com.sensedia.kotlin.infra.resources

import com.sensedia.kotlin.domain.services.GetRecommendationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("recommendations")
class GetRecommendationController(val getTrackService: GetRecommendationService) {

    @GetMapping()
    fun getWeather(@RequestParam temperature: Double) = getTrackService.getRecommendation(temperature)

}