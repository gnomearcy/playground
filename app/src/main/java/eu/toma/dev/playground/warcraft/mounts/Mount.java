package eu.toma.dev.playground.warcraft.mounts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mount {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("spellId")
    @Expose
    public Integer spellId;
    @SerializedName("creatureId")
    @Expose
    public Integer creatureId;
    @SerializedName("itemId")
    @Expose
    public Integer itemId;
    @SerializedName("qualityId")
    @Expose
    public Integer qualityId;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("isGround")
    @Expose
    public Boolean isGround;
    @SerializedName("isFlying")
    @Expose
    public Boolean isFlying;
    @SerializedName("isAquatic")
    @Expose
    public Boolean isAquatic;
    @SerializedName("isJumping")
    @Expose
    public Boolean isJumping;
}