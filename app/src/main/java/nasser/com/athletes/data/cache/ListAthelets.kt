package nasser.com.athletes.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "list_athelets")
data class ListAthelets(@ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)  var id: Long = 0,
                        @ColumnInfo(name = "athele_name")  var name: String = "",
                        @ColumnInfo(name = "athele_image")  var image: String = "",
                        @ColumnInfo(name = "athele_brief")  var brief: String = "")