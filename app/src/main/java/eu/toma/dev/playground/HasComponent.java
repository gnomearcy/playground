package eu.toma.dev.playground;

import android.support.annotation.NonNull;

public interface HasComponent<T>
{
    @NonNull T getComponent();
}
