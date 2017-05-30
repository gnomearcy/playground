package warcraft.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Spell
{
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("icon")
    @Expose
    lateinit var icon: String

    @SerializedName("description")
    @Expose
    lateinit var description: String

    @SerializedName("castTime")
    @Expose
    lateinit var castTime: String

    @SerializedName("cooldown")
    @Expose
    lateinit var cooldown: String
}
