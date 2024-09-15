package com.example.myapplication1.ui.theme

import androidx.lifecycle.ViewModel
import com.example.myapplication1.ElementsDescription
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AstroViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AstroUiState())
    val uiState: StateFlow<AstroUiState> = _uiState.asStateFlow()

    private var currentDescription: String = ""
    private var currentHoroscope: String = ""
    private var currentOppositeSign : String = ""
    private var currentMatch : String = ""

    fun determineTraits(sunSign: String, risingSign: String) {
        val element = determineRisingSignElement(risingSign)
        currentDescription = when(sunSign) {
            "Aries" -> when(element) {
                "Fire" -> ElementsDescription.ARIES_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.ARIES_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.ARIES_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.ARIES_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Taurus" -> when(element) {
                "Fire" -> ElementsDescription.TAURUS_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.TAURUS_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.TAURUS_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.TAURUS_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Gemini" -> when(element) {
                "Fire" -> ElementsDescription.GEMINI_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.GEMINI_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.GEMINI_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.GEMINI_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Cancer" -> when(element) {
                "Fire" -> ElementsDescription.CANCER_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.CANCER_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.CANCER_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.CANCER_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Leo" -> when(element) {
                "Fire" -> ElementsDescription.LEO_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.LEO_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.LEO_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.LEO_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Virgo" -> when(element) {
                "Fire" -> ElementsDescription.VIRGO_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.VIRGO_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.VIRGO_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.VIRGO_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Libra" -> when(element) {
                "Fire" -> ElementsDescription.LIBRA_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.LIBRA_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.LIBRA_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.LIBRA_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Scorpio" -> when(element) {
                "Fire" -> ElementsDescription.SCORPIO_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.SCORPIO_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.SCORPIO_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.SCORPIO_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Sagittarius" -> when(element) {
                "Fire" -> ElementsDescription.SAGITTARIUS_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.SAGITTARIUS_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.SAGITTARIUS_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.SAGITTARIUS_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Capricorn" -> when(element) {
                "Fire" -> ElementsDescription.CAPRICORN_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.CAPRICORN_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.CAPRICORN_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.CAPRICORN_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Aquarius" -> when(element) {
                "Fire" -> ElementsDescription.AQUARIUS_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.AQUARIUS_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.AQUARIUS_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.AQUARIUS_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            "Pisces" -> when(element) {
                "Fire" -> ElementsDescription.PISCES_DESCRIPTION + ElementsDescription.FIRE_DESCRIPTION
                "Air" -> ElementsDescription.PISCES_DESCRIPTION + ElementsDescription.AIR_DESCRIPTION
                "Earth" -> ElementsDescription.PISCES_DESCRIPTION + ElementsDescription.EARTH_DESCRIPTION
                "Water" -> ElementsDescription.PISCES_DESCRIPTION + ElementsDescription.WATER_DESCRIPTION
                else -> "Unknown combination"
            }
            else -> "Unknown combination"
        }
        _uiState.value = _uiState.value.copy(currentDescription = currentDescription)
    }
    fun determineHoroscope(currentSign: String) {
        currentHoroscope = when(currentSign) {
            "Aries" -> ElementsDescription.ARIES_YEARLY_HOROSCOPE
            "Taurus" -> ElementsDescription.TAURUS_YEARLY_HOROSCOPE
            "Gemini" -> ElementsDescription.GEMINI_YEARLY_HOROSCOPE
            "Cancer" -> ElementsDescription.CANCER_YEARLY_HOROSCOPE
            "Leo" -> ElementsDescription.LEO_YEARLY_HOROSCOPE
            "Virgo" -> ElementsDescription.VIRGO_YEARLY_HOROSCOPE
            "Libra" -> ElementsDescription.LIBRA_YEARLY_HOROSCOPE
            "Scorpio" -> ElementsDescription.SCORPIO_YEARLY_HOROSCOPE
            "Sagittarius" -> ElementsDescription.SAGITTARIUS_YEARLY_HOROSCOPE
            "Capricorn" -> ElementsDescription.CAPRICORN_YEARLY_HOROSCOPE
            "Aquarius" -> ElementsDescription.AQUARIUS_YEARLY_HOROSCOPE
            "Pisces" -> ElementsDescription.PISCES_YEARLY_HOROSCOPE
            else -> "Unknown Horoscope"
        }
        _uiState.value = _uiState.value.copy(currentHoroscope = currentHoroscope)
    }
    fun determineBestMatchDescription(risingSign: String) {
        var oppositeSign = determineOppositeSign(risingSign)
        currentMatch = when(oppositeSign) {
            "Aries" -> ElementsDescription.ARIES_SEVENTH_HOUSE
            "Taurus" -> ElementsDescription.TAURUS_SEVENTH_HOUSE
            "Gemini" -> ElementsDescription.GEMINI_SEVENTH_HOUSE
            "Cancer" -> ElementsDescription.CANCER_SEVENTH_HOUSE
            "Leo" -> ElementsDescription.LEO_SEVENTH_HOUSE
            "Virgo" -> ElementsDescription.VIRGO_SEVENTH_HOUSE
            "Libra" -> ElementsDescription.LIBRA_SEVENTH_HOUSE
            "Scorpio" -> ElementsDescription.SCORPIO_SEVENTH_HOUSE
            "Sagittarius" -> ElementsDescription.SAGITTARIUS_SEVENTH_HOUSE
            "Capricorn" -> ElementsDescription.CAPRICORN_SEVENTH_HOUSE
            "Aquarius" -> ElementsDescription.AQUARIUS_SEVENTH_HOUSE
            "Pisces" -> ElementsDescription.PISCES_SEVENTH_HOUSE
            else -> "Unknown best match description"
        }
        _uiState.value = _uiState.value.copy(currentBestMatch = currentMatch)
    }
    private fun determineOppositeSign(currentSign: String) : String {
        currentOppositeSign = when (currentSign) {
            "Aries" -> "Libra"
            "Taurus" -> "Scorpio"
            "Gemini" -> "Sagittarius"
            "Cancer" -> "Capricorn"
            "Leo" -> "Aquarius"
            "Virgo" -> "Pisces"
            "Libra" -> "Aries"
            "Scorpio" -> "Taurus"
            "Sagittarius" -> "Gemini"
            "Capricorn" -> "Cancer"
            "Aquarius" -> "Leo"
            "Pisces" -> "Virgo"
            else -> "Unknown opposite sign"
        }
        return currentOppositeSign
    }
    private fun determineRisingSignElement(currentSign: String): String {
        return when(currentSign) {
            "Aries", "Leo", "Sagittarius" -> "Fire"
            "Aquarius", "Libra", "Gemini" -> "Air"
            "Virgo", "Taurus", "Capricorn" -> "Earth"
            "Pisces", "Cancer", "Scorpio" -> "Water"
            else -> ""
        }
    }
    fun updateName(newName: String) {
        _uiState.value = _uiState.value.copy(currentName = newName)
    }
    fun updateSurname(newSurname: String) {
        _uiState.value = _uiState.value.copy(currentSurname = newSurname)
    }
    fun updateSunSign(newSunSign: String) {
        _uiState.value = _uiState.value.copy(currentSunSign = newSunSign)
    }
    fun updateRisingSign(newRisingSign: String) {
        _uiState.value = _uiState.value.copy(currentRisingSign = newRisingSign)
    }
}