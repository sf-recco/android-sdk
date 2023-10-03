package com.recco.api.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.recco.internal.core.model.metric.AppUserMetricAction
import com.recco.internal.core.model.metric.AppUserMetricCategory
import com.recco.internal.core.model.metric.AppUserMetricEvent
import com.recco.internal.core.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@Singleton
class ApplicationLifecycleObserver @Inject constructor(
    private val appRepository: AppRepository
) : DefaultLifecycleObserver {

    fun register(lifecycle: Lifecycle) {
        MainScope().launch {
            lifecycle.addObserver(this@ApplicationLifecycleObserver)
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        appRepository.logEvent(
            AppUserMetricEvent(
                category = AppUserMetricCategory.USER_SESSION,
                action = AppUserMetricAction.HOST_APP_OPEN
            )
        )
    }
}
