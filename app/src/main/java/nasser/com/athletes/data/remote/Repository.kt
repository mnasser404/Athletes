package nasser.com.athletes.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nasser.com.athletes.AppApplication
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.cache.AppDatabase
import nasser.com.athletes.data.cache.ListAtheletsDao

class Repository {


    private lateinit var database: AppDatabase
    private lateinit var dao: ListAtheletsDao

    constructor() {
        setupDataBase()
    }

    fun geDatatFromRemote(): MutableLiveData<List<AthleteModel.Athele>> {
        var data = Remote().startRequestToGetData()
        data?.let { data.value?.let { dao.insertAll(it) } }
        return data
    }

    fun getDataFromCache(): LiveData<List<AthleteModel.Athele>> {
        return dao.getAll()
    }


    fun setupDataBase() {
        database = AppApplication.database!!
        dao = database.listAtheletsDao()
    }


}