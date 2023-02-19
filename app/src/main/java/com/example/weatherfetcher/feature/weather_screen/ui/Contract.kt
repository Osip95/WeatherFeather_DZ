package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.Event
// абстракция состояния активити
data class ViewState(
    val isLoading: Boolean,
    val title: String,
    val temperature: String
)
// перечесление событий происходящих на активити
sealed class UiEvent(): Event {
    object OnButtonClicked : UiEvent()
}

// события которые происходят при обработке ошибок
sealed class DataEvent: Event {
    data class OnWeatherFetchSucced(val temperature: String) : DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable): DataEvent()
}