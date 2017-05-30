package warcraft.talents

import dagger.Component
import warcraft.di.WoWcomponent

@Talents
@Component(dependencies = arrayOf(WoWcomponent::class))
interface TalentComponent {
    fun inject(talents: TalentsActivity)
}
