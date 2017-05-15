package eu.toma.dev.playground.warcraft.model.item;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("stackable")
    @Expose
    public Integer stackable;
    @SerializedName("itemBind")
    @Expose
    public Integer itemBind;
    @SerializedName("bonusStats")
    @Expose
    public List<Object> bonusStats = null;
    @SerializedName("itemSpells")
    @Expose
    public List<ItemSpell> itemSpells = null;
    @SerializedName("buyPrice")
    @Expose
    public Integer buyPrice;
    @SerializedName("itemClass")
    @Expose
    public Integer itemClass;
    @SerializedName("itemSubClass")
    @Expose
    public Integer itemSubClass;
    @SerializedName("containerSlots")
    @Expose
    public Integer containerSlots;
    @SerializedName("inventoryType")
    @Expose
    public Integer inventoryType;
    @SerializedName("equippable")
    @Expose
    public Boolean equippable;
    @SerializedName("itemLevel")
    @Expose
    public Integer itemLevel;
    @SerializedName("maxCount")
    @Expose
    public Integer maxCount;
    @SerializedName("maxDurability")
    @Expose
    public Integer maxDurability;
    @SerializedName("minFactionId")
    @Expose
    public Integer minFactionId;
    @SerializedName("minReputation")
    @Expose
    public Integer minReputation;
    @SerializedName("quality")
    @Expose
    public Integer quality;
    @SerializedName("sellPrice")
    @Expose
    public Integer sellPrice;
    @SerializedName("requiredSkill")
    @Expose
    public Integer requiredSkill;
    @SerializedName("requiredAbility")
    @Expose
    public RequiredAbility requiredAbility;
    @SerializedName("requiredLevel")
    @Expose
    public Integer requiredLevel;
    @SerializedName("requiredSkillRank")
    @Expose
    public Integer requiredSkillRank;
    @SerializedName("itemSource")
    @Expose
    public ItemSource itemSource;
    @SerializedName("baseArmor")
    @Expose
    public Integer baseArmor;
    @SerializedName("hasSockets")
    @Expose
    public Boolean hasSockets;
    @SerializedName("isAuctionable")
    @Expose
    public Boolean isAuctionable;
    @SerializedName("armor")
    @Expose
    public Integer armor;
    @SerializedName("displayInfoId")
    @Expose
    public Integer displayInfoId;
    @SerializedName("nameDescription")
    @Expose
    public String nameDescription;
    @SerializedName("nameDescriptionColor")
    @Expose
    public String nameDescriptionColor;
    @SerializedName("upgradable")
    @Expose
    public Boolean upgradable;
    @SerializedName("heroicTooltip")
    @Expose
    public Boolean heroicTooltip;
    @SerializedName("context")
    @Expose
    public String context;
    @SerializedName("bonusLists")
    @Expose
    public List<Object> bonusLists = null;
    @SerializedName("availableContexts")
    @Expose
    public List<String> availableContexts = null;
    @SerializedName("bonusSummary")
    @Expose
    public BonusSummary bonusSummary;
    @SerializedName("artifactId")
    @Expose
    public Integer artifactId;

}