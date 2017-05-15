package eu.toma.dev.playground.warcraft.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BonusSummary {

    @SerializedName("defaultBonusLists")
    @Expose
    public List<Object> defaultBonusLists = null;
    @SerializedName("chanceBonusLists")
    @Expose
    public List<Object> chanceBonusLists = null;
    @SerializedName("bonusChances")
    @Expose
    public List<Object> bonusChances = null;
}