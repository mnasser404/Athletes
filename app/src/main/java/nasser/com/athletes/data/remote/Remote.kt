package nasser.com.athletes.data.remote

import android.content.Context
import androidx.lifecycle.MutableLiveData
import nasser.com.athletes.Utils.Companion.initRetrofit
import nasser.com.athletes.Models.AthleteModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Remote {


    private var context: Context

    constructor(context: Context) {
        this.context = context
    }







    fun startRequestToGetData(): MutableLiveData<List<AthleteModel.Athele>> {

        var athelets = MutableLiveData<List<AthleteModel.Athele>>()
        initRetrofit(context)?.create(APIs::class.java)?.getListOfAthelets()?.enqueue(object : Callback<AthleteModel> {
            override fun onFailure(call: Call<AthleteModel>, t: Throwable) {
                t.message
            }

            override fun onResponse(call: Call<AthleteModel>, response: Response<AthleteModel>) {
                athelets.value = response.body()?.athletes
            }
        })
        return athelets
    }









}