package eu.toma.dev.playground.warcraft.mounts.all;

import java.util.List;

import eu.toma.dev.playground.warcraft.mounts.Mount;

public interface MVP
{
    interface View
    {
        void onMounts(List<Mount> newMounts);

        void onMountsFetchError();

        void onNoMounts();

        void showLoading();

        void hideLoading();

        void showContent();

        void hideContent();
    }

    interface Presenter
    {
        void getMounts();
    }
}
