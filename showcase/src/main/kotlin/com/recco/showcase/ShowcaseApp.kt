package com.recco.showcase

import android.app.Application
import android.util.Log
import com.recco.api.model.ReccoConfig
import com.recco.api.model.ReccoLogger
import com.recco.api.model.ReccoStyle
import com.recco.api.ui.ReccoApiUI
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShowcaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initSDK(this)
    }

    companion object {
        fun initSDK(application: Application, style: ReccoStyle = ReccoStyle()) {
            ReccoApiUI.init(
                sdkConfig = ReccoConfig(
                    clientSecret = BuildConfig.CLIENT_SECRET,
                    style = style
                ),
                application = application,
                logger = object : ReccoLogger {
                    override fun e(e: Throwable, tag: String?, message: String?) {
                        Log.e(tag, message, e)
                    }

                    override fun d(message: String, tag: String?) {
                        Log.d(tag, message)
                    }
                }
            )
        }
    }
}
