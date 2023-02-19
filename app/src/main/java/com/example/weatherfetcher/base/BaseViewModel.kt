package com.example.weatherfetcher.base


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//Базовая вью-модель, в ней описан основной функционал.
abstract class BaseViewModel<VIEW_STATE> : ViewModel() {
// поле вьюстейт, тип лайфдата. Хранит в себе сущность VIEW_STATE-дата класс который является абстракцией активити, т.е.
// в данном дата-классе хранятся данные для отрисовки активити
    val viewState: MutableLiveData<VIEW_STATE> by lazy {MutableLiveData(initialViewState())}
// функция которая должна отрабатывать если VIEW_STATE не была создана
    abstract fun initialViewState(): VIEW_STATE
// функция котопая должна вернуть новое сотояние активити т.е. новый VIEW_STATE в зависимости от произошедшего события
    abstract  fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?
// функция которая вызывается при возникновении события на активити
    fun processUIEvent(event: Event){
        updateState(event)
    }
// в данном приложении вызывается при обработке ошибок
    protected  fun  processDataEvent(event: Event){
        updateState(event)
    }
// создает новую лайфдату, через метод reduce(), если она не нулевая и не соответсвует предыдущей лайфдате
// то обновляет данные
 private  fun updateState(event: Event) {
        val newViewState = reduce(event, viewState.value ?: initialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }



}