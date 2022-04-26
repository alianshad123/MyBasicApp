package com.anshad.baseapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.anshad.baseapp.base.constants.Actions
import com.anshad.baseapp.base.utils.Action
import com.anshad.baseapp.base.utils.EventObserver
import com.anshad.baseapp.base.utils.LoadingMessageData
import com.anshad.baseapp.base.utils.MessageData

abstract class BaseActivity: AppCompatActivity() {

    private val viewModel: BaseActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel.action.observe(this, EventObserver {
            onPerformAction(it)
        })
        viewModel.infoMessage.observe(this, EventObserver {
            onInfoMessage(it)
        })
        viewModel.loading.observe(this, EventObserver {
            onLoadingMessage(it)
        })
    }

    open fun onPerformAction(action: Action) {
        when (action.task.action) {
            Actions.ENTER_FULLSCREEN -> {
               // enterFullScreen(true)
            }
            Actions.EXIT_FULLSCREEN -> {
                //exitFullScreen()
            }
            Actions.ACTION_LOGOUT -> {
                onLogout()
            }
        }
    }

    abstract fun onLoadingMessage(messageData: LoadingMessageData)
    abstract fun onInfoMessage(messageData: MessageData)
    abstract fun onLogout()
}