package eu.span.dev.rxjava.warcraft.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Boss {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("urlSlug")
    @Expose
    public String urlSlug;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("zoneId")
    @Expose
    public Integer zoneId;
    @SerializedName("availableInNormalMode")
    @Expose
    public Boolean availableInNormalMode;
    @SerializedName("availableInHeroicMode")
    @Expose
    public Boolean availableInHeroicMode;
    @SerializedName("health")
    @Expose
    public Integer health;
    @SerializedName("heroicHealth")
    @Expose
    public Integer heroicHealth;
    @SerializedName("level")
    @Expose
    public Integer level;
    @SerializedName("heroicLevel")
    @Expose
    public Integer heroicLevel;
    @SerializedName("journalId")
    @Expose
    public Integer journalId;
    @SerializedName("npcs")
    @Expose
    public List<Npc> npcs = null;

}