package kaleidot725.myapplication.ui

import android.app.Application
import kaleidot725.myapplication.di.AppComponent
import kaleidot725.myapplication.di.DaggerAppComponent

class MyApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}