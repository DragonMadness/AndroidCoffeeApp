package com.github.dragonmadness.androidcoffeeapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.dragonmadness.androidcoffeeapp.database.FirestoreAccessor;

public class MainActivity extends AppCompatActivity {

    private FirestoreAccessor accessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.accessor = new FirestoreAccessor();
        this.accessor.getDepartments(departments -> {
            ListView departmentsList = findViewById(R.id.departments_list);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, departments);
            departmentsList.setAdapter(adapter);
        });
    }
}