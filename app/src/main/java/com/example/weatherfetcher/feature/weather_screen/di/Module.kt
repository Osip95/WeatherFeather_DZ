import com.example.weatherfetcher.BASE_URL
import com.example.weatherfetcher.feature.weather_screen.GetWeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.data.WeatherApi
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRemouteSource
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepoImpl
import com.example.weatherfetcher.feature.weather_screen.domain.WeatherRepo
import com.example.weatherfetcher.feature.weather_screen.presentation.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// внедрение зависимостей
val weatherScreenModule = module {

   single<OkHttpClient> {
       OkHttpClient.Builder().build() }

    single<Retrofit> {  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(get())
        .build() }

    single<WeatherApi> {get<Retrofit>().create(WeatherApi::class.java)}

    single<WeatherRemouteSource> { WeatherRemouteSource(get()) }

    single<WeatherRepo> { WeatherRepoImpl(get()) }

    single<GetWeatherInteractor> { GetWeatherInteractor(get()) }

    viewModel { WeatherScreenViewModel(get()) }

}