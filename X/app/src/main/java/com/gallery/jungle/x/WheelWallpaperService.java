package com.gallery.jungle.x;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.io.InputStream;

/*
 * This animated wallpaper draws a rotating wireframe cube.
 */
public class WheelWallpaperService extends WallpaperService {

    private final Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Engine onCreateEngine() {
        Bitmap imageBitmap;
        AssetManager assetManager = getAssets();

        try {
            InputStream ims = assetManager.open("chorki.png");
            imageBitmap = BitmapFactory.decodeStream(ims);
            return new WheelWallpaperEngine(imageBitmap);
        } catch (IOException e) {
            Log.d("Image", "Could not load asset");
            return null;
        }




    }

    class WheelWallpaperEngine extends Engine {
      //  private SurfaceHolder holder;


        private Bitmap imageBitmap;

        private static final int ROTATE_TIME_MILLIS=2000;

        private final Runnable drawImage = new Runnable() {
            public void run() {
                try{
                    drawFrame();
                }
                catch (Exception e) {
                }

            }
        };
        private boolean mVisible;

        WheelWallpaperEngine(Bitmap imageBitmap) {
            // Create a Paint to draw the lines for our cube
            this.imageBitmap=imageBitmap;
     }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

}

        @Override
        public void onDestroy() {
            super.onDestroy();
            mHandler.removeCallbacks(drawImage);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            mVisible = visible;
            if (visible) {

                try{
                    drawFrame();
                }
                catch (Exception e)
                {

                }
            }else {
                mHandler.removeCallbacks(drawImage);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            // store the center of the surface, so we can draw the cube in the
            // right spot
    try{
        drawFrame();
    }
    catch (Exception e)
    {

    }

        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            mVisible = false;
            mHandler.removeCallbacks(drawImage);
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xStep,
                                     float yStep, int xPixels, int yPixels) {

            try{
                drawFrame();
            }
            catch (Exception e)
            {

            }
        }

        /*
         * Store the position of the touch event so we can use it for drawing
         * later
         */
        void drawFrame() {
            final SurfaceHolder holder = getSurfaceHolder();

            Canvas c = null;
            try {
                c = holder.lockCanvas();
                if (c != null) {
                    // draw something
                    try{
                        drawCube(c);
                    }
                    catch (Exception e)
                    {

                    }

               }
            } finally {
                if (c != null)
                    holder.unlockCanvasAndPost(c);
            }

            // Reschedule the next redraw
            mHandler.removeCallbacks(drawImage);
            if (mVisible) {
                mHandler.postDelayed(drawImage, 1000 / 25);
            }
        }

        /*
         * Draw a wireframe cube by drawing 12 3 dimensional lines between
         * adjacent corners of the cube
         */
        void drawCube(Canvas canvas) {
            Matrix matrix = new Matrix();
            canvas.save();

            canvas.drawColor(Color.BLACK);

            float angle = (float) (System.currentTimeMillis() % ROTATE_TIME_MILLIS) / ROTATE_TIME_MILLIS * 360;

            matrix.reset();
            matrix.postTranslate(-imageBitmap.getWidth() / 2, -imageBitmap.getHeight() / 2);
            matrix.postRotate(-angle);
            matrix.postTranslate(canvas.getWidth()/2, canvas.getHeight()/2 );

            canvas.drawBitmap(imageBitmap, matrix, null);

            canvas.restore();
        }


    }
}