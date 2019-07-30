package nasser.com.athletes.data

import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.Utils
import retrofit2.Call
import retrofit2.http.GET

interface APIs {
    @GET(Utils.ATHELETS_URL)
    fun getListOfAthelets(): Call<AthleteModel>
}