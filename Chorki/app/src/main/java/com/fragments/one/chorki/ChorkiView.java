package com.fragments.one.chorki;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by khan on 3/31/2015.
 */
public class ChorkiView extends Fragment {

    ImageView my_image;
    Animation.AnimationListener listener;

    public ChorkiView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        listener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }
        };

        my_image = (ImageView) rootView.findViewById(R.id.imageView);
        load_animations();

        return rootView;
    }

    void load_animations() {
        new AnimationUtils();
        Animation rotation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotator);
        rotation.setAnimationListener(listener);
        my_image.startAnimation(rotation);
    }
}
