package com.example.huan.imagehandle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button btnPrimaryColor;
    private Button btnColorMatrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrimaryColor = (Button) findViewById(R.id.btnPrimaryColor);
        btnPrimaryColor.setOnClickListener(this);
        btnColorMatrix = (Button) findViewById(R.id.btnColorMatrix);
        btnColorMatrix.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPrimaryColor:
                startActivity(new Intent(this, PrimaryColor.class));
                break;
            case R.id.btnColorMatrix:
                startActivity(new Intent(this, ColorMatrix.class));
                break;
        }
    }
}
