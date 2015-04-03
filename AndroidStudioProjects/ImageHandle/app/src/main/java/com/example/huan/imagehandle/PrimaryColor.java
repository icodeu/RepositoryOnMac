package com.example.huan.imagehandle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by huan on 15/3/30.
 */
public class PrimaryColor extends Activity implements SeekBar.OnSeekBarChangeListener{
    private ImageView mImageView;
    private SeekBar mSeekbarHue, mSeekbarSaturation, mSeekbarLum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float mHue, mSaturation, mLum;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mSeekbarHue = (SeekBar) findViewById(R.id.seekbarHue);
        mSeekbarSaturation = (SeekBar) findViewById(R.id.seekbarSaturation);
        mSeekbarLum = (SeekBar) findViewById(R.id.seekbarLum);

        mSeekbarHue.setOnSeekBarChangeListener(this);
        mSeekbarSaturation.setOnSeekBarChangeListener(this);
        mSeekbarLum.setOnSeekBarChangeListener(this);

        mSeekbarHue.setMax(MAX_VALUE);
        mSeekbarSaturation.setMax(MAX_VALUE);
        mSeekbarLum.setMax(MAX_VALUE);
        mSeekbarHue.setProgress(MID_VALUE);
        mSeekbarSaturation.setProgress(MID_VALUE);
        mSeekbarLum.setProgress(MID_VALUE);


        mImageView.setImageBitmap(bitmap);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbarHue:
                mHue = (progress  - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.seekbarSaturation:
                mSaturation = (progress) * 1.0F / MID_VALUE;
                break;
            case R.id.seekbarLum:
                mLum = (progress) * 1.0F / MID_VALUE;
                break;
        }
        System.out.println("*****************************");
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
