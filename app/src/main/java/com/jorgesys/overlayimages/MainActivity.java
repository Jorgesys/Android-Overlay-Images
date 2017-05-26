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

        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.androide);

        Bitmap bmpImages = overlayBitmap(background, image);
        imageView.setImageBitmap(bmpImages);
    }


    public static Bitmap overlayBitmap(Bitmap bitmapBackground, Bitmap bitmapImage) {

        int bitmap1Width = bitmapBackground.getWidth();
        int bitmap1Height = bitmapBackground.getHeight();
        int bitmap2Width = bitmapImage.getWidth();
        int bitmap2Height = bitmapImage.getHeight();

        float marginLeft = (float) (bitmap1Width * 0.5 - bitmap2Width * 0.5);
        float marginTop = (float) (bitmap1Height * 0.5 - bitmap2Height * 0.5);

        Bitmap overlayBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bitmapBackground.getConfig());
        Canvas canvas = new Canvas(overlayBitmap);
        canvas.drawBitmap(bitmapBackground, new Matrix(), null);
        canvas.drawBitmap(bitmapImage, marginLeft, marginTop, null);

        return overlayBitmap;
    }


}
