package com.example.weatherfetcher.base
//функция которая используется для обработки ошибок
inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}