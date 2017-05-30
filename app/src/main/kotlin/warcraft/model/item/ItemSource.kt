package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemSource {

    @SerializedName("sourceId")
    @Expose
    var sourceId: Int? = null
    @SerializedName("sourceType")
    @Expose
    var sourceType: String

}
