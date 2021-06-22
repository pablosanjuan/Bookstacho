package com.bookstacho.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bookstacho.BaseActivity
import com.bookstacho.R

class LoginActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
  }

  companion object {
    fun start(context: Context) {
      val intent = Intent(context, LoginActivity::class.java)
      context.startActivity(intent)
    }
  }
}