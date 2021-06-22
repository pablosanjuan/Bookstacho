package com.bookstacho.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bookstacho.BaseActivity
import com.bookstacho.BktApplication
import com.bookstacho.R
import com.bookstacho.domain.entities.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val user : User = intent.getParcelableExtra(USER) ?: return
    text_view.text = "Hi " + user.name

      val preferenceRepository = (application as BktApplication).preferenceRepository

      preferenceRepository.isDarkThemeLive.observe(this, Observer { isDarkTheme ->
          isDarkTheme?.let { dark_theme_switch.isChecked = it }
      })

      dark_theme_switch.setOnCheckedChangeListener { _, checked ->
          preferenceRepository.isDarkTheme = checked
      }

      (application as BktApplication).preferenceRepository
          .nightModeLive.observe(this, Observer { nightMode ->
              nightMode?.let { delegate.localNightMode = it }
          }
          )
  }

  companion object {
    private const val USER = "user"
    fun start(context: Context, user: User) {
        val intent = Intent(context, MainActivity::class.java).apply {
          putExtra(USER, user)
        }
        context.startActivity(intent)
    }
  }
}