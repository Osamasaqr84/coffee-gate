package com.noname.coffee_gate.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class HomeViewModel : ViewModel() {

    private val sliderLiveData = MutableLiveData<Long>()

    val getSliderLiveData: LiveData<Long>
        get() = sliderLiveData

    private  val compositeDisposable : CompositeDisposable= CompositeDisposable()

    private val subscribe = Observable.interval(SLIDER_INTERVAL, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {sliderLiveData.postValue(it)}


    init {

        compositeDisposable.add(subscribe)

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    companion object {
        const val SLIDER_INTERVAL : Long  = 3000
    }

}
