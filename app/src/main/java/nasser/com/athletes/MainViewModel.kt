package nasser.com.athletes

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.remote.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private lateinit var viewData: LiveData<List<AthleteModel.Athele>>


    fun loadViewData(): LiveData<List<AthleteModel.Athele>> {
        viewData = Repository().getDataFromCache()
        viewData.value?.let {
            if (it.isEmpty()) {
                if (isNetworkAvailable(context)) {
                    viewData = Repository().geDatatFromRemote()
                } else {
                    //ToDo Show Error Messages
                }
            }
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