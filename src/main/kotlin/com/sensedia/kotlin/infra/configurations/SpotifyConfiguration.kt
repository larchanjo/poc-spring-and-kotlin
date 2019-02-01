package com.sensedia.kotlin.infra.configurations

import com.wrapper.spotify.SpotifyApi
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpotifyConfiguration {

    val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun createSpotifyApi(
            @Value("\${spotify.client-id}") clientId: String,
            @Value("\${spotify.client-secret}") clientSecret: String
    ): SpotifyApi {
        log.info("Creating SpotifyApi")
        val spotifyApi = SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build()

        val clientCredentialsRequest = spotifyApi.clientCredentials().build()
        val clientCredentials = clientCredentialsRequest.execute()
        spotifyApi.accessToken = clientCredentials.accessToken
        log.info("Access token ${clientCredentials.accessToken} expires in ${clientCredentials.expiresIn}(s)")

        return spotifyApi
    }

}