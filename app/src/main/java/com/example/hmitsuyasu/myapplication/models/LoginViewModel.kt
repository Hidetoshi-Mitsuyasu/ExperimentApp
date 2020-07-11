package com.example.hmitsuyasu.myapplication.models

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository
import kotlinx.coroutines.launch


class LoginViewModel(
    val settingRepository: ISettingRepository
) : ViewModel(), LifecycleObserver {

    // 獲得圏内アイコン表示判定
    private val _isWithIn = ObservableBoolean(false)
    val isWithIn: Boolean = _isWithIn.get()

    // 今日時点でのランキング
    private val _currentScore = MutableLiveData<String>()
    val currentScore = _currentScore.distinctUntilChanged()

    init {
        _currentScore.postValue("-")
    }

    fun onUpdateCurrentScore(score: Boolean) {
        _isWithIn.set(score)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getCurrentRanking() {
        viewModelScope.launch {
            onUpdateCurrentScore(settingRepository.getPh2OtaAvailableOn())
        }
    }
}