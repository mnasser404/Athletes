package nasser.com.athletes.Models

import java.io.Serializable

class AthleteModel {

    val athletes : List<Athele> = emptyList()

    inner class Athele : Serializable{
        val name:String = ""
        val image:String = ""
        val brief:String = ""
    }

}