package cbassdagreat.github.boardgamesboji.model


import com.google.gson.annotations.SerializedName

data class Classification(
    @SerializedName("category")
    val category: String,
    @SerializedName("mechanisms")
    val mechanisms: String
)