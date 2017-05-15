package eu.toma.dev.playground.warcraft.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spell {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("castTime")
    @Expose
    public String castTime;

}