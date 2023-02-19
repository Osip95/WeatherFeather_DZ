package com.example.weatherfetcher.feature.weather_screen.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.weatherfetcher.R
import com.example.weatherfetcher.feature.weather_screen.presentation.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()
    val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFeathc)}
    val tvTemperature: TextView by lazy{ findViewById(R.id.tvTemperature) }
    val progressBar: ProgressBar by lazy{ findViewById(R.id.progrses_bar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// подписываемся на изменнеия в лайфдате, если изменниея есть то вызвать метод render()
        viewModel.viewState.observe(this,::render)
// при нажатии на кнопку, оповестить вью модель - событием UiEvent.OnButtonClicked
        fabWeather.setOnClickListener{
            viewModel.processUIEvent(UiEvent.OnButtonClicked)
        }

    }
// отобразить прогрес бар если данные еще не получены и в TextView отобразить полученные данне из лайфДаты
    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        tvTemperature.text = "${viewState.title} ${viewState.temperature}"
    }
}