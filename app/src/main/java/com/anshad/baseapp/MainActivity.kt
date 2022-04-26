package com.anshad.baseapp

import android.os.Bundle
import com.anshad.baseapp.base.BaseActivity
import com.anshad.baseapp.base.utils.LoadingMessageData
import com.anshad.baseapp.base.utils.MessageData

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onLoadingMessage(messageData: LoadingMessageData) {
        TODO("Not yet implemented")
    }

    override fun onInfoMessage(messageData: MessageData) {
        TODO("Not yet implemented")
    }

    override fun onLogout() {
        TODO("Not yet implemented")
    }
}