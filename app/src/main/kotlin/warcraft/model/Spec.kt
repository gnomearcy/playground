package warcraft.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Spec {
    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("role")
    @Expose
    lateinit var role: String

    @SerializedName("backgroundImage")
    @Expose
    lateinit var backgroundImage: String

    @SerializedName("icon")
    @Expose
    lateinit var icon: String

    @SerializedName("description")
    @Expose
    lateinit var description: String

    @SerializedName("order")
    @Expose
    var order: Int? = null
}
