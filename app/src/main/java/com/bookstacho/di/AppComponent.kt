package com.bookstacho.di

import com.bookstacho.BaseActivity
import com.bookstacho.BktApplication
import com.bookstacho.data.di.DataModule
import com.bookstacho.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {

  fun inject(bkApplication: BktApplication)
  fun inject(baseActivity: BaseActivity)

}