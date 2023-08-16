package jp.ac.it_college.std.s22017.pbl

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class CustomApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        // configuration 構築
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()
        Realm.setDefaultConfiguration(config)
    }
}