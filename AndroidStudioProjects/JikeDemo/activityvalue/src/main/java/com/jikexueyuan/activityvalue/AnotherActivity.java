package com.jikexueyuan.activityvalue;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AnotherActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        TextView tv = (TextView) findViewById(R.id.textView);
        User user = (User) getIntent().getSerializableExtra("user");
        Book book = getIntent().getParcelableExtra("book");
        tv.setText("name: " + user.getName() + " age: " + user.getAge() + "\n" + "name: " + book.getName() + " price: " + book.getPrice());
    }

}
