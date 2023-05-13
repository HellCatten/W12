package com.example.w12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFirstName, editTextLastName, editTextAge;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null,1));
        editTextFirstName = findViewById(R.id.etFirstName);
        editTextLastName = findViewById(R.id.etLastName);
        editTextAge = findViewById(R.id.etAge);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd) {
            Log.i("W12_TAG", "bthAdd");
            if(this.dbManager != null) {
                String fName = editTextFirstName.getText().toString();
                String lName = editTextLastName.getText().toString();
                String age = editTextAge.getText().toString();
                if(!fName.isEmpty() && !lName.isEmpty() && !age.isEmpty()) {
                    boolean result = dbManager.savePersonToDatabase(new Person(fName,lName,Integer.parseInt(age)));
                    if (result) {
                        Toast.makeText(this,R.string.insert_success,Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,R.string.insert_error,Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(this,R.string.incorrect_value,Toast.LENGTH_LONG).show();
                }
            }
        }
        if(v.getId() == R.id.btnNext) {
            Log.i("W12_TAG", "BtnNext");
            startActivity(new Intent(this, PersonActivity.class));
        }

    }
}