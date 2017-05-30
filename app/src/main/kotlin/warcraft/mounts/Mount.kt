package warcraft.mounts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Mount {
    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("spellId")
    @Expose
    var spellId: Int? = null

    @SerializedName("creatureId")
    @Expose
    var creatureId: Int? = null

    @SerializedName("itemId")
    @Expose
    var itemId: Int? = null

    @SerializedName("qualityId")
    @Expose
    var qualityId: Int? = null

    @SerializedName("icon")
    @Expose
    lateinit var icon: String

    @SerializedName("isGround")
    @Expose
    var isGround: Boolean? = null

    @SerializedName("isFlying")
    @Expose
    var isFlying: Boolean? = null

    @SerializedName("isAquatic")
    @Expose
    var isAquatic: Boolean? = null

    @SerializedName("isJumping")
    @Expose
    var isJumping: Boolean? = null
}