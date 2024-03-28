package vlkv.example.wasd

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class model(
    @SerializedName("content")
    val content:String) {
}