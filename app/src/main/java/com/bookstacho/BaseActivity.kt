package com.bookstacho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bookstacho.di.Injector
import com.bookstacho.domain.repositories.UserRepository
import com.bookstacho.domain.usecases.UserUseCase
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

  @Inject
  lateinit var repository: UserRepository

  @Inject
  lateinit var userUserCase: UserUseCase

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Injector.component().inject(this)
  }

}