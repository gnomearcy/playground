package warcraft.di

import dagger.Component
import eu.toma.dev.playground.GlobalComp
import eu.toma.dev.playground.warcraft.api.MediaApi
import eu.toma.dev.playground.warcraft.api.WoWApi

@Warcraft
@Component(modules = arrayOf(WoWModule::class), dependencies = arrayOf(GlobalComp::class))
interface WoWcomponent {
    fun provideApi(): WoWApi

    fun mediaApi(): MediaApi
}
