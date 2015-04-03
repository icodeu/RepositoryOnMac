package com.example.huan.imagehandle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by huan on 15/4/1.
 */
public class ColorMatrix extends Activity {

    private Button changeBtn;
    private GridLayout gridLayout;
    private Bitmap bitmap;
    private ImageView imageView;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20];
    private int etWidth, etHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);


        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                etWidth = gridLayout.getWidth() / 5;
                etHeight = gridLayout.getHeight() / 4;

                addEts();
                initColorMatrix();
            }
        });

        changeBtn = (Button) findViewById(R.id.button);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMatrix();
                setImageMatrix();
            }
        });
    }

    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        android.graphics.ColorMatrix colorMatrix = new android.graphics.ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        imageView.setImageBitmap(bmp);
    }

    private void getMatrix() {
        for (int i=0;i<20;i++){
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
        }
    }

    private void addEts() {
        for (int i=0;i<20;i++){
            EditText editText = new EditText(ColorMatrix.this);
            mEts[i] = editText;
            gridLayout.addView(editText, etWidth, etHeight);
        }
    }

    private void initColorMatrix() {
        for (int i=0;i<20;i++){
            if (i % 6 == 0) {
                mEts[i].setText("1");
            }
            else {
                mEts[i].setText("0");
            }
        }
    }



}
