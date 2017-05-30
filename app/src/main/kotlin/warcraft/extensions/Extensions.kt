@file:JvmName("ExtensionUtils")

package warcraft.extensions

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false) : View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot);
}

inline fun <reified T : Parcelable> createParcel(crossinline c: (Parcel) -> T?)
        : Parcelable.Creator<T> =
    object: Parcelable.Creator<T> {
        override fun createFromParcel(source: Parcel): T? = c(source);
        override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size);
}

fun Parcel.readBoolean() = this.readInt() == 1

fun Parcel.writeBoolean(value: Boolean)= writeInt(if (value) 1 else 0)
