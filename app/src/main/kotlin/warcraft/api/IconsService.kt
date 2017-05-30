package warcraft.api

import javax.inject.Inject

import io.reactivex.Observable
import warcraft.di.Warcraft

@Warcraft
class IconsService
@Inject
constructor(private val api: MediaApi) {

    val getIcon56 :Observable<*>?
    get()
    {
        // TODO make an api call and query the icon
        return null
    }
}
