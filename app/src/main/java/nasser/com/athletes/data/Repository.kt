package nasser.com.athletes.data

import nasser.com.athletes.Models.Athlete

class Repository {


    fun geDatatFromRemote(): List<Athlete> {
       return Remote().startRequestToGetData()
    }


}