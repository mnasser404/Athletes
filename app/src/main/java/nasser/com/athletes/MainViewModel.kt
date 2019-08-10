package nasser.com.athletes

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.net.ConnectivityManager
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.remote.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private lateinit var viewData: MutableLiveData<List<AthleteModel.Athele>>

    fun loadViewData(): LiveData<List<AthleteModel.Athele>> {
        if (isNetworkAvailable(context)) {
            viewData = Repository().geDatatFromRemote()
        } else {
            viewData = Repository().getDataFromCache()
        }
        return viewData
    }


    fun isNetworkAvailable(context: Context): Boolean {
        var isConnected = false
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo = connectivityManager.activeNetworkInfo
        activeNetworkInfo?.let { isConnected = it.isConnected }
        return isConnected
    }


}