package eu.toma.dev.playground.warcraft.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


@Scope
@Retention(RetentionPolicy.SOURCE)
public @interface MountScope
{
}
