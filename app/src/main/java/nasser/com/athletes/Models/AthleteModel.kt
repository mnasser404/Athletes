package nasser.com.athletes.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class AthleteModel {

    val athletes: List<Athele> = emptyList()

    @Entity(tableName = "list_athelets")
    data class Athele(@ColumnInfo(name = "id") @PrimaryKey var id: String = "",
                      @ColumnInfo(name = "athele_name") var name: String = "",
                      @ColumnInfo(name = "athele_image") var image: String = "",
                      @ColumnInfo(name = "athele_brief") var brief: String = "") : Serializable {
    }


}