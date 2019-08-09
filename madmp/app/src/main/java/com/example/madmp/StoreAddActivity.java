package com.example.madmp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

import java.util.ArrayList;

public class StoreAddActivity extends Activity {
    private EditText username_edit;
    private EditText placename_edit;
    private Spinner foodtype_spinner;
    private CheckBox bread, pho, soup;

    private Button submit_btn;
    private ArrayList<String> checkbox_items;
    //private Button submit_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_add);

        username_edit = (EditText) findViewById(R.id.username_edit);
        placename_edit = (EditText) findViewById(R.id.placename_edit);
        foodtype_spinner = (Spinner) findViewById(R.id.foodtype_spinner);
        bread = (CheckBox) findViewById(R.id.bread_checkbox);
        pho = (CheckBox) findViewById(R.id.pho_checkbox);
        soup = (CheckBox) findViewById(R.id.soup_checkbox);

        checkbox_items = new ArrayList<>();

        //displaySpinner();
        submitForm();
    }
    
    public void submitForm() {
        submit_btn = (Button) findViewById(R.id.store_submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonClick();
            }
        });
    }
    private void handleButtonClick() {
        String username = username_edit.getText().toString();
        String placename = placename_edit.getText().toString();
        String foodtype_text = foodtype_spinner.getSelectedItem().toString();

        System.out.println(checkbox_items);
        System.out.println(MadmpUtils.convertArrayListToString(checkbox_items));
        if (username.isEmpty() || username == null)
        {
            username_edit.setError("Username cannot be blank!");
        }
        else if (placename.isEmpty() || placename == null)
        {
            placename_edit.setError("Place cannot be blank");
        }
        else
        {
            Intent i = new Intent(this, StoreConfirmActivity.class);
            i.putExtra("username", username);
            i.putExtra("placename", placename);
            i.putExtra("foodtype", foodtype_text);
            startActivity(i);
        }
    }


    public void displaySpinner(View view) {
        String[] foodtypes= getResources().getStringArray(R.array.foodtype_arrays);
        ArrayAdapter<String> foodtype_spinner_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, foodtypes);
        foodtype_spinner.setAdapter(foodtype_spinner_adapter);
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.bread_checkbox:
                bread = (CheckBox) findViewById(R.id.bread_checkbox);
                if (checked)
                {
                    checkbox_items.add(bread.getText().toString());
                }
                else
                {
                    checkbox_items.remove(bread.getText().toString());
                }
                break;
            case R.id.pho_checkbox:
                pho = (CheckBox) findViewById(R.id.pho_checkbox);
                if (checked)
                {
                    checkbox_items.add(pho.getText().toString());
                }
                else
                {
                    checkbox_items.remove(pho.getText().toString());
                }
                break;
            case R.id.soup_checkbox:
                soup = (CheckBox) findViewById(R.id.soup_checkbox);
                if (checked)
                {
                    checkbox_items.add(soup.getText().toString());
                }
                else
                {
                    checkbox_items.remove(soup.getText().toString());
                }
                break;
        }
    }
}
