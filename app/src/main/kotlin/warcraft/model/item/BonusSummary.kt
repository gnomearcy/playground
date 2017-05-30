package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BonusSummary {

    @SerializedName("defaultBonusLists")
    @Expose
    var defaultBonusLists: List<Any>? = null
    @SerializedName("chanceBonusLists")
    @Expose
    var chanceBonusLists: List<Any>? = null
    @SerializedName("bonusChances")
    @Expose
    var bonusChances: List<Any>? = null
}