package com.bookstacho.di

import android.app.Application
import android.content.Context
import com.bookstacho.BktApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule (val application: BktApplication) {

  @Provides
  internal fun provideContext() : Context = application

  @Provides
  internal fun provideApplication() : Application = application

  @Provides
  internal fun provideBkApplication() : BktApplication = application

}