package eu.toma.dev.playground.warcraft.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemSpell {

    @SerializedName("spellId")
    @Expose
    public Integer spellId;
    @SerializedName("spell")
    @Expose
    public Spell spell;
    @SerializedName("nCharges")
    @Expose
    public Integer nCharges;
    @SerializedName("consumable")
    @Expose
    public Boolean consumable;
    @SerializedName("categoryId")
    @Expose
    public Integer categoryId;
    @SerializedName("trigger")
    @Expose
    public String trigger;

}