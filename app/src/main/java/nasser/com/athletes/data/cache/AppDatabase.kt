package nasser.com.athletes.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(ListAthelets::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listAtheletsDao() : ListAtheletsDao
}