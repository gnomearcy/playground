package warcraft.mounts.adapter

import android.os.Parcel
import android.os.Parcelable
import warcraft.extensions.readBoolean
import warcraft.extensions.writeBoolean


// "ViewModel" for a mount list item
data class MountItem
(
    val name: String,
    // Part of a url to download an image via MediaApi
    var icon: String,
    var isGround: Boolean,
    var isFlying: Boolean,
    var isAquatic: Boolean,
    var isJumping: Boolean
) : ViewType, Parcelable
{
    override fun getViewType() = AdapterConstants.MOUNTS
    override fun describeContents() = 0

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readBoolean(),
            source.readBoolean(),
            source.readBoolean(),
            source.readBoolean())

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR: Parcelable.Creator<MountItem> = object : Parcelable.Creator<MountItem> {
            override fun createFromParcel(source: Parcel): MountItem = MountItem(source)
            override fun newArray(size: Int): Array<MountItem?> = arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(icon)
        dest.writeBoolean(isGround)
        dest.writeBoolean(isFlying)
        dest.writeBoolean(isAquatic)
        dest.writeBoolean(isJumping)
    }
}
