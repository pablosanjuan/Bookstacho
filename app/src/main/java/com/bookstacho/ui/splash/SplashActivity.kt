package com.bookstacho.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bookstacho.BaseActivity
import com.bookstacho.R
import com.bookstacho.domain.entities.User
import com.bookstacho.domain.repositories.UserRepository
import com.bookstacho.domain.usecases.UserUseCase
import com.bookstacho.ui.login.LoginActivity
import com.bookstacho.ui.main.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        disposables.add(
            Observable.just(Unit).observeOn(Schedulers.io()).delay(SPLASH_TIME, TimeUnit.SECONDS)
                .subscribe {
                    checkUser()
                })

    }

    private fun checkUser() {
        disposables.add(Observable.fromCallable { userUserCase.run() }
            .subscribeOn(Schedulers.io())
            .subscribe { result ->
                result.fold({
                    //LoginActivity.start(this@SplashActivity)
                    MainActivity.start(this@SplashActivity, User("1", "pablo"))
                }, {
                    MainActivity.start(this@SplashActivity, it)
                })
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    companion object {
        const val SPLASH_TIME = 3L
    }
}