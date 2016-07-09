package com.wheels.one.wheel;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;

/**
 * Created by khan on 3/31/2015.
 */
public class ChorkiWallpaperService extends WallpaperService {

    /*   public Activity activity ;
       private Bitmap image;
       Animation.AnimationListener listener;

       public ChorkiWallpaperService() {

       }
       public ChorkiWallpaperService(Activity _activity) {
           this.activity = _activity;
       }

       @Override
       public Engine onCreateEngine() {
           return new ChorkiWallpaperEngine();
       }

       private class ChorkiWallpaperEngine extends Engine {


           @Override
           public Bundle onCommand(String action, int x, int y, int z, Bundle extras, boolean resultRequested) {
               return super.onCommand(action, x, y, z, extras, resultRequested);
           }

           @Override
           public void onCreate(SurfaceHolder surfaceHolder) {
               super.onCreate(surfaceHolder);
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
               image=BitmapFactory.decodeResource(r,R.drawable.on);
              /// my_image = (ImageView) getApplicationContext().findViewById(R.id.imageView);
               load_animations();



           }

           @Override
           public void onDestroy() {
               super.onDestroy();
           }

           @Override
           public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
               super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
           }

           @Override
           public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
               super.onSurfaceChanged(holder, format, width, height);
           }

           @Override
           public void onSurfaceCreated(SurfaceHolder holder) {
               super.onSurfaceCreated(holder);

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

              // my_image = (ImageView) activity.findViewById(R.id.imageView);
               load_animations();

           }

           @Override
           public void onSurfaceDestroyed(SurfaceHolder holder) {
               super.onSurfaceDestroyed(holder);
           }

           @Override
           public void onVisibilityChanged(boolean visible) {
               super.onVisibilityChanged(visible);
           }

           public void load_animations() {
               new AnimationUtils();
               Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);
               rotation.setAnimationListener(listener);
               image.startAnimation(rotation);
           }

       }*/
    private final int frameDuration = 20;


    public Engine onCreateEngine() {
        try {
            Movie movie = Movie.decodeStream(
                    getResources().getAssets().open("chorki.gif"));

            return new ChorkiWallpaperEngine(movie);
        } catch (IOException e) {
            Log.d("GIF", "Could not load asset");
            return null;
        }
    }


    private class ChorkiWallpaperEngine extends Engine {

        Runnable drawGIF = new Runnable() {
            public void run() {
                draw();
            }
        };
        private SurfaceHolder holder;
        private Movie movie;
        private boolean visible;
        private Handler handler;

        public ChorkiWallpaperEngine(Movie movie) {
            this.movie = movie;
            handler = new Handler();
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            this.holder = surfaceHolder;
        }

        private void draw() {
            if (visible) {
                Canvas canvas = holder.lockCanvas();
                canvas.save();
                // Adjust size and position so that
                // the image looks good on your screen
                canvas.scale(3f, 3f);
                movie.draw(canvas, -100, 0);
                canvas.restore();
                holder.unlockCanvasAndPost(canvas);
                movie.setTime((int) (System.currentTimeMillis() % movie.duration()));

                handler.removeCallbacks(drawGIF);
                handler.postDelayed(drawGIF, frameDuration);
            }
        }

        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(drawGIF);
            } else {
                handler.removeCallbacks(drawGIF);
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(drawGIF);
        }

    }
}


