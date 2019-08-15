package nasser.com.athletes.data.remote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.cache.AppDatabase
import nasser.com.athletes.data.cache.ListAtheletsDao
import java.util.*

class Repository {


    private lateinit var database: AppDatabase
    private lateinit var dao: ListAtheletsDao
    private var context: Context
    private var remote : Remote? = null

    constructor(context: Context) {
        this.context = context
        setupDataBase(context)
    }

    fun geDatatFromRemote(): MutableLiveData<List<AthleteModel.Athele>> {
        if(remote == null){
            remote = Remote(context)
        }

        var data = remote!!.startRequestToGetData()

        data?.let {
            data.value?.let {
                prepareDataForDB(it)
                dao.insertAll(it)
            }
        }

        return data
    }


    fun getDataFromCache(): LiveData<List<AthleteModel.Athele>> {
        return dao.getAll()
    }


    fun setupDataBase(context: Context) {
        database = AppDatabase.getDataBaseInstance(context)
        dao = database.listAtheletsDao()
    }


    fun prepareDataForDB(athelets: List<AthleteModel.Athele>) {
        for (athele in athelets) {
            athele.id = UUID.randomUUID().toString()
        }
    }


}