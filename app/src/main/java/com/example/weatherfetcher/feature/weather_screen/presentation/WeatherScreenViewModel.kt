package com.example.weatherfetcher.feature.weather_screen.presentation


import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.GetWeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.ui.DataEvent
import com.example.weatherfetcher.feature.weather_screen.ui.UiEvent
import com.example.weatherfetcher.feature.weather_screen.ui.ViewState
import kotlinx.coroutines.launch

// вью модел - наследует функционал базовой вьюмодели.
class WeatherScreenViewModel(val interactor: GetWeatherInteractor) : BaseViewModel<ViewState>() {

// инициализация лайфДаты
    override fun initialViewState(): ViewState = ViewState(isLoading = false, title = "hello", temperature = "")
// если пользователь нажал на кнопку, то в параметр прийдет UiEvent.OnButtonClicked. Скопируется предыдущее сотояние
// активити и если ошибок нет то в копии предыдущего сотояния изменятс данные:
// - temperature - возьмятся из  сети
// - isLoading = false (отвечает за отображение прогрессБара)
    override  fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {  interactor().fold(
                    onError = {
                        processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.OnWeatherFetchSucced(temperature = it.temperature))
                    }
                )
                }

                return previousState.copy(isLoading = true)
            }

            is DataEvent.OnWeatherFetchSucced -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            else -> return null
        }
    }
}