package com.gallery.jungle.on;

import android.content.Context;
import android.service.wallpaper.WallpaperService;
import android.view.View;

/**
 * Created by Salman on 4/26/2016.
 */
public class Wheel extends View {
    public Wheel(Context context) {
        super(context);
        WheelWallpaper w = new WheelWallpaper(context);

    }
    private class WheelWallpaper extends WallpaperService{
        public WheelWallpaper(Context context) {

        }
        @Override
        public Engine onCreateEngine() {
            return null;
        }
    }
}
