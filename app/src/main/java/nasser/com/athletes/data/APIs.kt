package nasser.com.athletes.data

import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.BusinessConstants
import nasser.com.athletes.BusinessConstants.Companion.ATHELETS_URL
import retrofit2.Call
import retrofit2.http.GET

interface APIs {
    @GET(ATHELETS_URL)
    fun getListOfAthelets(): Call<AthleteModel>
}