package nasser.com.athletes.data.remote

import android.arch.lifecycle.MutableLiveData
import nasser.com.athletes.Models.AthleteModel

class Repository {


    fun geDatatFromRemote(): MutableLiveData<List<AthleteModel.Athele>> {
        return Remote().startRequestToGetData()
    }

    fun getDataFromCache(): MutableLiveData<List<AthleteModel.Athele>> {
        return Remote().startRequestToGetData()
    }


}