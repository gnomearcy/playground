package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Spell {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String
    @SerializedName("icon")
    @Expose
    var icon: String
    @SerializedName("description")
    @Expose
    var description: String
    @SerializedName("castTime")
    @Expose
    var castTime: String

}