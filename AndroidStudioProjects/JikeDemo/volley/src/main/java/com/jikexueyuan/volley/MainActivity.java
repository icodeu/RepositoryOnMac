package com.jikexueyuan.volley;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    private ImageView imageView;
    private NetworkImageView networkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);

        getJsonVolley();
        loadImageVolley();
        loadNetworkImageView();
    }

    public void getJsonVolley(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String dataUrl = "http://m.weather.com.cn/data/101201401.html";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, dataUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        System.out.println(jsonObject);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("Error " + volleyError);
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

    public void loadImageVolley(){
        String imgUrl = "http://assets.jikexueyuan.com/practice/list_android.jpg";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final LruCache<String, Bitmap> lruCache = new LruCache<>(20);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }

            @Override
            public void putBitmap(String key, Bitmap bitmap) {
                lruCache.put(key, bitmap);
            }
        };

        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
        ImageLoader.ImageListener listener = imageLoader.getImageListener(imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get(imgUrl, listener);
    }

    public void loadNetworkImageView(){
        String imgUrl = "http://assets.jikexueyuan.com/practice/list_android.jpg";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final LruCache<String ,Bitmap> lruCache = new LruCache<>(20);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }

            @Override
            public void putBitmap(String key, Bitmap bitmap) {
                lruCache.put(key, bitmap);
            }
        };
        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
        networkImageView.setTag("url");
        networkImageView.setImageUrl(imgUrl, imageLoader);
    }

}
