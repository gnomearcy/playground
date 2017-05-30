package warcraft.model.boss

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Boss {

    @SerializedName("id")
    @Expose
    var id: Int? = null;

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("urlSlug")
    @Expose
    lateinit var urlSlug: String

    @SerializedName("description")
    @Expose
    lateinit var description: String

    @SerializedName("zoneId")
    @Expose
    var zoneId: Int? = null

    @SerializedName("availableInNormalMode")
    @Expose
    var availableInNormalMode: Boolean? = null

    @SerializedName("availableInHeroicMode")
    @Expose
    var availableInHeroicMode: Boolean? = null

    @SerializedName("health")
    @Expose
    var health: Int? = null

    @SerializedName("heroicHealth")
    @Expose
    var heroicHealth: Int? = null

    @SerializedName("level")
    @Expose
    var level: Int? = null

    @SerializedName("heroicLevel")
    @Expose
    var heroicLevel: Int? = null
    @SerializedName("journalId")
    @Expose
    var journalId: Int? = null

    @SerializedName("npcs")
    @Expose
    lateinit var npcs: List<Npc>
}
