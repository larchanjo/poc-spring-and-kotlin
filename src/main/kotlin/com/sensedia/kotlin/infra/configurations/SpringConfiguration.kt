package com.sensedia.kotlin.infra.configurations

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class SpringConfiguration {

    val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun createRestTemplate(): RestTemplate {
        log.info("Creating RestTemplate")
        return RestTemplate()
    }

}