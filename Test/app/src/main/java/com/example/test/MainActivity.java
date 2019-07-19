package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.view.View;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {
    private EditText mNameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_entry);
        mNameText = (EditText)findViewById(R.id.name);
        Button theClickedButton = (Button) findViewById(R.id.press);
        Button theNotClickedButton = (Button) findViewById(R.id.notpress);
        theClickedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonClick();
            }
        });
        theNotClickedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonNotClick();
            }
        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void handleButtonClick() {
        String strName = mNameText.getText().toString();
        Intent i = new Intent(this, NameDisplay.class);
        i.putExtra(NameDisplay.NAME, strName);
        startActivity(i);
    }

    private void handleButtonNotClick() {
        mNameText.setText("I told you not to click :< !");
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
