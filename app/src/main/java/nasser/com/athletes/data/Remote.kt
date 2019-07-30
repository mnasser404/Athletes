package nasser.com.athletes.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {


    fun initRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    fun startRequestToGetData(): MutableLiveData<List<AthleteModel.Athele>> {

        var athelets = MutableLiveData<List<AthleteModel.Athele>>()
        initRetrofit().create(APIs::class.java).getListOfAthelets().enqueue(object : Callback<AthleteModel>{
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