package nasser.com.athletes

import android.app.Application
import androidx.room.Room
import nasser.com.athletes.data.cache.AppDatabase

class AppApplication : Application() {

    companion object{
        var database : AppDatabase? = null
    }


    override fun onCreate() {
        super.onCreate()
        AppApplication.database = Room.databaseBuilder(this, AppDatabase::class.java, "atheles-db").build()
    }
}