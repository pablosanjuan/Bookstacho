package com.bookstacho.di

class Injector {
  companion object {
    private lateinit var appComponent: AppComponent
    fun init(appComponent: AppComponent) { this.appComponent = appComponent }
    fun component() = appComponent
  }
}