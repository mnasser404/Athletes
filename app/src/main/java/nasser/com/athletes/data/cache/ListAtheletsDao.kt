package nasser.com.athletes.data.cache

import android.arch.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import nasser.com.athletes.Models.AthleteModel

@Dao
interface ListAtheletsDao {

    @Query("SELECT * FROM list_athelets")
    fun getAll(): MutableLiveData<List<AthleteModel.Athele>>

    @Insert
    fun insertAll(athelets: List<AthleteModel.Athele>)

}