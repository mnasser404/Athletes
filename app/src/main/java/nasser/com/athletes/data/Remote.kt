package nasser.com.athletes.data

import nasser.com.athletes.Models.Athlete
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

    fun startRequestToGetData(): List<Athlete> {
        var athelets = listOf<Athlete>()
        val api = initRetrofit().create(APIs::class.java)
        api.getListOfAthelets().enqueue(object : Callback<List<Athlete>> {
            override fun onResponse(call: Call<List<Athlete>>, response: Response<List<Athlete>>) {
                    athelets = response.body()!!
            }
            override fun onFailure(call: Call<List<Athlete>>, t: Throwable) {

            }

        })
        return athelets
    }




}