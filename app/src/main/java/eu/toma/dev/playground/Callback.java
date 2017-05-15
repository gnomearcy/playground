package eu.toma.dev.playground;

/**
 * Created by tmartincic on 14-May-17.
 */

public interface Callback<T>
{
    void onSuccess(T data);

    void onError();
}
