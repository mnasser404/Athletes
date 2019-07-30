package nasser.com.athletes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.data.Repository

class MainViewModel : ViewModel() {


    fun loadViewData(): LiveData<List<AthleteModel.Athele>> {
        var viewData = Repository().geDatatFromRemote()
        return viewData
    }


}