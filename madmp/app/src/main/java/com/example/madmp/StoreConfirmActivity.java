package com.example.madmp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StoreConfirmActivity extends Activity {
    private TextView username_view;
    private TextView placename_view;
    private TextView foodtype_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_confirmation);

        username_view = (TextView)findViewById(R.id.show_username);
        placename_view = (TextView)findViewById(R.id.show_placename);
        foodtype_view = (TextView)findViewById(R.id.show_foodtype);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String username = extras.getString("username");
            String placename = extras.getString("placename");
            String foodtype = extras.getString("foodtype");

            username_view.setText("Username: " + username);
            placename_view.setText("Placename: " + placename);
            foodtype_view.setText("Placename: " + foodtype);
        }
    }
}
