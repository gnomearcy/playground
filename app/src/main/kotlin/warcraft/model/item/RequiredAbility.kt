package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequiredAbility {

    @SerializedName("spellId")
    @Expose
    var spellId: Int? = null
    @SerializedName("name")
    @Expose
    var name: String
    @SerializedName("description")
    @Expose
    var description: String

}