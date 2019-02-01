package com.sensedia.kotlin.domain.services

import com.neovisionaries.i18n.CountryCode
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.specification.Recommendations
import org.springframework.stereotype.Service

@Service
class GetRecommendationService(val spotifyApi: SpotifyApi) {

    fun getRecommendation(temperature: Double): Recommendations? {
        val style = getStyleByTemperature(temperature)
        return spotifyApi.recommendations
                .limit(10)
                .market(CountryCode.BR)
                .seed_genres(style)
                .build().execute()
    }

    private fun getStyleByTemperature(temperature: Double) = when (temperature) {
        in 0..10 -> "pop"
        in 10..20 -> "rock"
        in 30..40 -> "electro"
        else -> "classical"
    }

}