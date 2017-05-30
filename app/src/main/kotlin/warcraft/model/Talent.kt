package warcraft.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Talent {

    @SerializedName("tier")
    @Expose
    var tier: Int? = null
    @SerializedName("column")
    @Expose
    var column: Int? = null
    @SerializedName("spell")
    @Expose
    var spell: Spell
    @SerializedName("spec")
    @Expose
    var spec: Spec
}