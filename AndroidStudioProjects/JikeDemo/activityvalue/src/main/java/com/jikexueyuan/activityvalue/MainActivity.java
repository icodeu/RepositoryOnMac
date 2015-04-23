package com.jikexueyuan.activityvalue;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                User user = new User("jikexueyuan", 2);
                Book book = new Book("android", 35);
                intent.putExtra("user", user);
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });

    }

}
