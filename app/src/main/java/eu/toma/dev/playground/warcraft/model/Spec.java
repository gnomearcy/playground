package eu.toma.dev.playground.warcraft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Spec
{
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("backgroundImage")
    @Expose
    public String backgroundImage;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("order")
    @Expose
    public Integer order;
}
