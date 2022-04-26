package com.anshad.baseapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anshad.baseapp.base.utils.Action
import com.anshad.baseapp.base.utils.Event

class BaseActivityViewModel : BaseViewModel() {
    private val actionPerformedLiveData = MutableLiveData<Event<Action>>()
    val actionPerformed: LiveData<Event<Action>> = actionPerformedLiveData

    fun actionPerformed(actions: Action) {
        actionPerformedLiveData.value = Event(actions)
    }
}