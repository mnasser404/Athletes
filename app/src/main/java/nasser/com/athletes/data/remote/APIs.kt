package nasser.com.athletes.data.remote

import nasser.com.athletes.BusinessConstants.Companion.ATHELETS_URL
import nasser.com.athletes.Models.AthleteModel
import retrofit2.Call
import retrofit2.http.GET

interface APIs {
    @GET(ATHELETS_URL)
    fun getListOfAthelets(): Call<AthleteModel>
}