package eu.toma.dev.playground.warcraft;

import android.support.annotation.NonNull;

public class Presenter<T>
{
    protected T view;

    protected void attachView(@NonNull T view){
        this.view = view;
    }

    protected void releaseView(){
        this.view = null;
    }
}
