package com.jorgesys.overlayimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Bitmap a = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.androide);

        Bitmap bmpImages = overlayBitmapToCenter(a, b);
        imageView.setImageBitmap(bmpImages);
    }


    public static Bitmap overlayBitmapToCenter(Bitmap bitmap1, Bitmap bitmap2) {
        int bitmap1Width = bitmap1.getWidth();
        int bitmap1Height = bitmap1.getHeight();
        int bitmap2Width = bitmap2.getWidth();
        int bitmap2Height = bitmap2.getHeight();

        Log.i(TAG, "bitmap1Width: " + bitmap1Width + ", bitmap1Height: " + bitmap1Height);
        Log.i(TAG, "bitmap2Width: " + bitmap2Width + ", bitmap2Height: " + bitmap2Height);

        float marginLeft = (float) (bitmap1Width * 0.5 - bitmap2Width * 0.5);
        float marginTop = (float) (bitmap1Height * 0.5 - bitmap2Height * 0.5);

        Bitmap overlayBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bitmap1.getConfig());
        Canvas canvas = new Canvas(overlayBitmap);
        canvas.drawBitmap(bitmap1, new Matrix(), null);
        canvas.drawBitmap(bitmap2, marginLeft, marginTop, null);
        return overlayBitmap;
    }


}
