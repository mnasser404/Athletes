package nasser.com.athletes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.remote.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private var viewData = MutableLiveData<List<AthleteModel.Athele>>()


    fun loadViewData(): LiveData<List<AthleteModel.Athele>> {
            viewData = Repository(context).geDatatFromRemote()

        return viewData
    }





}