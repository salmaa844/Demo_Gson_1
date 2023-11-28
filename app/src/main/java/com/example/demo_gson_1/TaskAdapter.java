package com.example.demo_gson_1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, int activity_tasks, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View viewnew = view;
        if (viewnew == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewnew = inflater.inflate(R.layout.activity_tasks, null);
        }

        final Task task = getItem(position);
        if (task != null) {
            TextView taskText = viewnew.findViewById(R.id.txtTask);
            Button btnText = viewnew.findViewById(R.id.btnTask);

            taskText.setText(task.getName());
            btnText.setOnClickListener(v->{
                task.setDone(true);
                notifyDataSetChanged();
                remove(task);
                sendToSecondPage(task);

            });
        }

        return viewnew;
    }

    private void sendToSecondPage(Task task) {

        Intent intent = new Intent(getContext(), SecondActivity.class);
        intent.putExtra("taskName", task.getName());
        getContext().startActivity(intent);
        Toast.makeText(getContext(), " task is done "+ task.getName()+"Click save to save the deletion ", Toast.LENGTH_SHORT).show();
    }
}