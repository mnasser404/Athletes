package nasser.com.athletes.data.remote

import androidx.lifecycle.MutableLiveData
import nasser.com.athletes.BusinessConstants.Companion.BASE_URL
import nasser.com.athletes.Models.AthleteModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {


    fun initRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    fun startRequestToGetData(): MutableLiveData<List<AthleteModel.Athele>> {

        var athelets = MutableLiveData<List<AthleteModel.Athele>>()
        initRetrofit().create(APIs::class.java).getListOfAthelets().enqueue(object : Callback<AthleteModel> {
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