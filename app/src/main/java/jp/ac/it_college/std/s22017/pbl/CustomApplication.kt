package jp.ac.it_college.std.s22017.pbl

import android.app.Application
import io.realm.Realm

class CustomApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

    }
}