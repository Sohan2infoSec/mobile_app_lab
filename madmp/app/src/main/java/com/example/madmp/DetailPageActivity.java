package com.example.madmp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class DetailPageActivity extends Activity {
    private EditText username;
    private EditText placename;
    private Spinner foodtype_spinner;
    private Button submit_btn;
    //private Button submit_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        displaySpinner();

        submitForm();
    }

    public void displaySpinner() {
        foodtype_spinner = (Spinner) findViewById(R.id.foodtype_spinner);
        String[] foodtypes= getResources().getStringArray(R.array.foodtype_arrays);
        ArrayAdapter<String> foodtype_spinner_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, foodtypes);
        foodtype_spinner.setAdapter(foodtype_spinner_adapter);
    }

    public void submitForm() {
        submit_btn = (Button) findViewById(R.id.detail_submit);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonClick();
            }
        });
    }

    private void handleButtonClick() {
        username = findViewById(R.id.username);
        placename = findViewById(R.id.placename);


        String usr = username.getText().toString();
        String plc = placename.getText().toString();
        String foodtype_text = foodtype_spinner.getSelectedItem().toString();

        System.out.println("---+User " + usr);
        System.out.println("---+Place " + plc);
        System.out.println("---+Place " + foodtype_text);

        Intent i = new Intent(this, DetailPageDisplay.class);
        i.putExtra("username", usr);
        i.putExtra("placename", plc);
        i.putExtra("foodtype", foodtype_text);
        startActivity(i);
    }
}
