package com.bookstacho

import android.app.Application
import android.content.Context
import com.bookstacho.data.PreferenceRepository
import com.bookstacho.data.di.DataModule
import com.bookstacho.di.AppComponent
import com.bookstacho.di.AppModule
import com.bookstacho.di.DaggerAppComponent
import com.bookstacho.di.Injector

class BktApplication : Application() {

    lateinit var preferenceRepository: PreferenceRepository


    override fun onCreate() {
        super.onCreate()
        initInjector()
        initTheme()
    }

    private fun initTheme() {
        preferenceRepository = PreferenceRepository(
            getSharedPreferences(DEFAULT_PREFERENCES, Context.MODE_PRIVATE)
        )
    }

    fun initInjector() {
        Injector.init(createAppComponent())
        Injector.component().inject(this)
    }

    fun createAppComponent() : AppComponent {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .build()
    }

    companion object {
        const val DEFAULT_PREFERENCES = "default_preferences"
    }

}