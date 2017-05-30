package warcraft.model.boss

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Npc {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String
    @SerializedName("urlSlug")
    @Expose
    var urlSlug: String
}
