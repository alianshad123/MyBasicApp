package com.anshad.baseapp.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anshad.baseapp.R
import com.anshad.baseapp.base.utils.Action
import com.anshad.baseapp.base.utils.Event
import com.anshad.baseapp.base.utils.LoadingMessageData
import com.anshad.baseapp.base.utils.MessageData

abstract class BaseViewModel : ViewModel() {
    private val infoMessageLiveData = MutableLiveData<Event<MessageData>>()
    val infoMessage: LiveData<Event<MessageData>> = infoMessageLiveData


    private val actionLiveData = MutableLiveData<Event<Action>>()
    val action: LiveData<Event<Action>> = actionLiveData

    private val loadingLiveData = MutableLiveData<Event<LoadingMessageData>>()
    val loading: LiveData<Event<LoadingMessageData>> = loadingLiveData


    fun showInfoMessage(message: MessageData) {
        infoMessageLiveData.value = Event(message)
    }

    open fun showLoading(message: LoadingMessageData) {
        loadingLiveData.value = Event(message)
    }

    fun performAction(action: Action) {
        actionLiveData.value = Event(action)
    }

    fun showLoading(@StringRes message: Int = R.string.loading) {
        val messageData = LoadingMessageData()
        messageData.isLoading = true
        messageData.messageRes = message
        showLoading(messageData)
    }

    fun hideLoading() {
        val messageData = LoadingMessageData()
        messageData.isLoading = false
        showLoading(messageData)
    }

}