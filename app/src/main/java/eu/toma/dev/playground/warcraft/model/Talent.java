package eu.toma.dev.playground.warcraft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Talent {

    @SerializedName("tier")
    @Expose
    public Integer tier;
    @SerializedName("column")
    @Expose
    public Integer column;
    @SerializedName("spell")
    @Expose
    public Spell spell;
    @SerializedName("spec")
    @Expose
    public Spec spec;
}