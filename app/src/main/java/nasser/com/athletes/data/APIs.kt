package nasser.com.athletes.data

import nasser.com.athletes.Models.Athlete
import retrofit2.Call

interface APIs {

    fun getListOfAthelets(): Call<List<Athlete>>

}