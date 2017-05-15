package eu.toma.dev.playground.warcraft.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequiredAbility {

    @SerializedName("spellId")
    @Expose
    public Integer spellId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;

}