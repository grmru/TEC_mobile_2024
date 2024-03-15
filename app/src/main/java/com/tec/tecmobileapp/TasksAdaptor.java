package com.tec.tecmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdaptor extends
        RecyclerView.Adapter<TasksAdaptor.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView isDoneTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.tName);
            isDoneTextView = (TextView) itemView.findViewById(R.id.tIsDone);
        }

    }


    // Store a member variable for the contacts
    private List<ToDoItem> lTasks;

    // Pass in the contact array into the constructor
    public TasksAdaptor(List<ToDoItem> tasks) {
        lTasks = tasks;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public TasksAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TasksAdaptor.ViewHolder holder, int position) {
        // Get the data model based on position
        ToDoItem task = lTasks.get(position);

        // Set item views based on your views and data model
        TextView tName = holder.nameTextView;
        tName.setText(task.getName());

        TextView tIsDone = holder.isDoneTextView;
        tIsDone.setText(task.getIsDone() ? "[1]" : "[0]");
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return lTasks.size();
    }

}
