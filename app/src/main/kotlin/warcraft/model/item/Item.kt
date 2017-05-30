package warcraft.model.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("description")
    @Expose
    lateinit var description: String

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("icon")
    @Expose
    lateinit var icon: String

    @SerializedName("stackable")
    @Expose
    var stackable: Int? = null

    @SerializedName("itemBind")
    @Expose
    var itemBind: Int? = null
    @SerializedName("bonusStats")
    @Expose
    var bonusStats: List<Any>? = null
    @SerializedName("itemSpells")
    @Expose
    var itemSpells: List<ItemSpell>? = null
    @SerializedName("buyPrice")
    @Expose
    var buyPrice: Int? = null
    @SerializedName("itemClass")
    @Expose
    var itemClass: Int? = null
    @SerializedName("itemSubClass")
    @Expose
    var itemSubClass: Int? = null
    @SerializedName("containerSlots")
    @Expose
    var containerSlots: Int? = null
    @SerializedName("inventoryType")
    @Expose
    var inventoryType: Int? = null
    @SerializedName("equippable")
    @Expose
    var equippable: Boolean? = null
    @SerializedName("itemLevel")
    @Expose
    var itemLevel: Int? = null
    @SerializedName("maxCount")
    @Expose
    var maxCount: Int? = null
    @SerializedName("maxDurability")
    @Expose
    var maxDurability: Int? = null
    @SerializedName("minFactionId")
    @Expose
    var minFactionId: Int? = null
    @SerializedName("minReputation")
    @Expose
    var minReputation: Int? = null
    @SerializedName("quality")
    @Expose
    var quality: Int? = null
    @SerializedName("sellPrice")
    @Expose
    var sellPrice: Int? = null
    @SerializedName("requiredSkill")
    @Expose
    var requiredSkill: Int? = null

    @SerializedName("requiredAbility")
    @Expose
    lateinit var requiredAbility: RequiredAbility

    @SerializedName("requiredLevel")
    @Expose
    var requiredLevel: Int? = null
    @SerializedName("requiredSkillRank")
    @Expose
    var requiredSkillRank: Int? = null

    @SerializedName("itemSource")
    @Expose
    lateinit var itemSource: ItemSource

    @SerializedName("baseArmor")
    @Expose
    var baseArmor: Int? = null
    @SerializedName("hasSockets")
    @Expose
    var hasSockets: Boolean? = null
    @SerializedName("isAuctionable")
    @Expose
    var isAuctionable: Boolean? = null
    @SerializedName("armor")
    @Expose
    var armor: Int? = null
    @SerializedName("displayInfoId")
    @Expose
    var displayInfoId: Int? = null

    @SerializedName("nameDescription")
    @Expose
    lateinit var nameDescription: String

    @SerializedName("nameDescriptionColor")
    @Expose
    lateinit var nameDescriptionColor: String

    @SerializedName("upgradable")
    @Expose
    var upgradable: Boolean? = null
    @SerializedName("heroicTooltip")
    @Expose
    var heroicTooltip: Boolean? = null

    @SerializedName("context")
    @Expose
    lateinit var context: String

    @SerializedName("bonusLists")
    @Expose
    var bonusLists: List<Any>? = null

    @SerializedName("availableContexts")
    @Expose
    var availableContexts: List<String>? = null

    @SerializedName("bonusSummary")
    @Expose
    lateinit var bonusSummary: BonusSummary

    @SerializedName("artifactId")
    @Expose
    var artifactId: Int? = null

}