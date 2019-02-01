package com.sensedia.kotlin.infra.configurations

import com.sensedia.kotlin.domain.OpenWeatherApi
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class OpenWeatherConfiguration {

    val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun createOpenWeatherApi(
            @Value("\${openweather.api-key}") apiKey: String,
            restTemplate: RestTemplate
    ): OpenWeatherApi {
        log.info("Creating OpenWeatherApi")
        return OpenWeatherApi(apiKey, restTemplate)
    }

}