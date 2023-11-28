package com.example.demo_gson_1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String taskName = getIntent().getStringExtra("taskName");
        TextView textView = findViewById(R.id.txtlist);
        textView.setText("Task Name: " + taskName);
        Button btndo =findViewById(R.id.btndo);
        btndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();

            }
        });


    }

    private void savedata() {
        Toast.makeText(this, "save done list ", Toast.LENGTH_SHORT).show();
    }
}