package com.example.demo_gson_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnSave;
    private EditText txtName;
    private ListView list_tasks;
    private ArrayList<Task> tasks;
    private TaskAdapter adapter;

    String Data="shared preference";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasksdo);
        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);
        txtName = findViewById(R.id.txtName);
        list_tasks = findViewById(R.id.list_tasks);
        loadData();// Load data from SharedPreferences
        adapter = new TaskAdapter(this, R.layout.activity_tasks, tasks);
        list_tasks.setAdapter(adapter);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveItem(v);
            }
        });

        list_tasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeleteItem(position);
            }
        });
    }
    private void SaveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(Data, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tasks);
        editor.putString("task list", json);
        editor.apply();
    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Task>>() {
        }.getType();
        tasks = gson.fromJson(json, type);

        if (tasks == null) {
            tasks = new ArrayList<>();
        }
    }

    private void DeleteItem(int position) {
        Context context = getApplicationContext();
        Toast.makeText(context, "Done Task", Toast.LENGTH_SHORT).show();
        tasks.remove(position);
        adapter.notifyDataSetChanged();
    }

    private void SaveItem(View v) {

        String itemText = txtName.getText().toString();
        if (!itemText.equals("")) {
            Task newTask = new Task(itemText, false);
            tasks.add(newTask);
            adapter.notifyDataSetChanged();
            txtName.setText("");
            Toast.makeText(getApplicationContext(), "ADD Success " + itemText +"enter to save", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter Due Task", Toast.LENGTH_SHORT).show();
        }
    }
}