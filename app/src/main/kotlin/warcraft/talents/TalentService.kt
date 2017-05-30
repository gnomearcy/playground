package warcraft.talents

import javax.inject.Inject

import io.reactivex.Observable
import warcraft.api.WoWApi
import warcraft.model.Talent

@Talents
class TalentService
@Inject
constructor(private val api: WoWApi) {

    val talents: Observable<Talent>?
    // TODO to be implemented
        get() = null
}

