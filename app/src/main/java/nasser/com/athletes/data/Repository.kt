package nasser.com.athletes.data

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.net.ConnectivityManager
import nasser.com.athletes.Models.AthleteModel

class Repository {


    fun geDatatFromRemote(): MutableLiveData<List<AthleteModel.Athele>> {
        return Remote().startRequestToGetData()
    }


    fun isNetworkAvailable(context: Context): Boolean {
        var isConnected = false
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo = connectivityManager.activeNetworkInfo
        activeNetworkInfo?.let { isConnected = it.isConnected }
        return isConnected
    }


}