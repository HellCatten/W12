package com.example.w12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {

    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        RecyclerView rcView = findViewById(R.id.recyclerView);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null,1));
        ArrayList<Person> persons = dbManager.loadAllPersonsFromDatabase();
        PersonAdapter adapter = new PersonAdapter(persons);
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);

    }
}