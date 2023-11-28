package com.example.demo_gson_1;


import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView =findViewById(R.id.listTasks);

        AdapterView.OnItemClickListener itemClickListener =(parent, view, position, id) -> {
           if (position == 0){
               Intent intent = new Intent(MainActivity.this, TaskActivity.class);
               startActivity(intent);
           } else if (position == 1) {
               Intent intent = new Intent(MainActivity.this,SecondActivity.class);
               startActivity(intent);
           }
        };
        listView.setOnItemClickListener(itemClickListener);

    }

}

