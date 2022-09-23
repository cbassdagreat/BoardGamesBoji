package cbassdagreat.github.boardgamesboji.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "board_game")
data class BojiItem(
    @SerializedName("age")
    val age: String,
    @SerializedName("Artist")
    val artist: String,
    //@SerializedName("classification")
    //val classification: Classification,
    @SerializedName("description")
    val description: String,
    @SerializedName("Designer")
    val designer: String,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("official_link")
    val officialLink: String,
    @SerializedName("players")
    val players: String,
    @SerializedName("playing_time")
    val playingTime: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("Publisher")
    val publisher: String,
    @SerializedName("year")
    val year: Int
)