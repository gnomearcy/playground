package eu.toma.dev.playground.warcraft.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemSource {

    @SerializedName("sourceId")
    @Expose
    public Integer sourceId;
    @SerializedName("sourceType")
    @Expose
    public String sourceType;

}
