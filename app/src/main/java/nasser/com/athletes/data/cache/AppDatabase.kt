package nasser.com.athletes.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nasser.com.athletes.Models.AthleteModel


@Database(entities = arrayOf(AthleteModel.Athele::class), version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun listAtheletsDao(): ListAtheletsDao


    companion object {
        private var database: AppDatabase? = null

        fun getDataBaseInstance(context: Context): AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context, AppDatabase::class.java, "atheles-db").build()
            }
            return database as AppDatabase
        }
    }


}