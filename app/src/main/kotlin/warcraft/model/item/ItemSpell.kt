package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemSpell {

    @SerializedName("spellId")
    @Expose
    var spellId: Int? = null
    @SerializedName("spell")
    @Expose
    var spell: Spell
    @SerializedName("nCharges")
    @Expose
    var nCharges: Int? = null
    @SerializedName("consumable")
    @Expose
    var consumable: Boolean? = null
    @SerializedName("categoryId")
    @Expose
    var categoryId: Int? = null
    @SerializedName("trigger")
    @Expose
    var trigger: String

}