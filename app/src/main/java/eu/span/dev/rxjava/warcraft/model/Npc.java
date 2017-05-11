package eu.span.dev.rxjava.warcraft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Npc
{
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("urlSlug")
    @Expose
    public String urlSlug;
}
