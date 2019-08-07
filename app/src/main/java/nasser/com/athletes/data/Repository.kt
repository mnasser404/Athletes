package nasser.com.athletes.data

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.net.ConnectivityManager
import nasser.com.athletes.Models.AthleteModel

class Repository {


    fun geDatatFromRemote(): MutableLiveData<List<AthleteModel.Athele>> {
        return Remote().startRequestToGetData()
    }

    fun getDataFromCache(): MutableLiveData<List<AthleteModel.Athele>> {
        return Remote().startRequestToGetData()
    }


}