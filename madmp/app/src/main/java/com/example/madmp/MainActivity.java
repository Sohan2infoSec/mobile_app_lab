package com.example.madmp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    private EditText name, surname, marks, id;
    private Button addButton, viewAllButton, updateButton, deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        id = (EditText) findViewById(R.id.editID);
        name = (EditText) findViewById(R.id.editName);
        surname = (EditText) findViewById(R.id.editSurname);
        marks = (EditText) findViewById(R.id.editMarks);

        addButton = (Button) findViewById(R.id.addButton);
        viewAllButton = (Button) findViewById(R.id.showButton);
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

    public void addData()
    {
        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = db.insertData( name.getText().toString(),
                                surname.getText().toString(),
                                marks.getText().toString() );
                        if (isInserted)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void viewAll()
    {
        viewAllButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = db.getAllData();
                        if ( res.getCount() == 0 )
                        {
                            showMessage("Error", "Nothing Found!");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("Name: " + res.getString(1) + "\n");
                            buffer.append("Surname: " + res.getString(2) + "\n");
                            buffer.append("Marks: " + res.getString(3) + "\n\n");
                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }
    public void showMessage (String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void updateData()
    {
        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = db.updateData( id.getText().toString(),
                                name.getText().toString(),
                                surname.getText().toString(),
                                marks.getText().toString());

                        if ( isUpdate )
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void deleteData()
    {
        deleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deleteRows = db.deleteData(id.getText().toString());

                        if ( deleteRows > 0 )
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
