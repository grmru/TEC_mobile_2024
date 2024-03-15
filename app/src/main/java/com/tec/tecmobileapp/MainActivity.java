package com.tec.tecmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    CheckBox chk;

    ArrayList<ToDoItem> tasks;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button123);
        txt = (TextView) findViewById(R.id.textView);
        chk = (CheckBox) findViewById(R.id.checkBox);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPress();
            }
        });

        Button btn2 = (Button)findViewById(R.id.buttonTestLoad);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPress2();
            }
        });

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.recyclerView);
        // Initialize contacts
        tasks = new ArrayList<ToDoItem>();
        tasks.add(new ToDoItem("Новая задача 1", "без комментариев", false));
        tasks.add(new ToDoItem("Новая задача 2", "без комментариев", true));
        tasks.add(new ToDoItem("Новая задача 3", "без комментариев", false));
        // Create adapter passing in the sample user data
        TasksAdaptor adapter = new TasksAdaptor(tasks);
        // Attach the adapter to the recyclerview to populate items
        rvTasks.setAdapter(adapter);
        // Set layout manager to position the items
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }

    public void btnPress()
    {
        Log.d("BUTTONS", "Пользователь нажал кнопку");

        boolean checked = chk.isChecked();

        String str = "нажата";
        if (!checked) { str = "не нажата"; };

        count++;
        txt.setText("Пользователь нажал кнопку " + count + " раз, галочка " + str);
    }

    public void btnPress2()
    {
        String str = "данные данные данные данные данные данные данные данные данные данные данные";

        /*try
        {
            FileOutputStream fl_out = openFileOutput("test.txt", Context.MODE_PRIVATE);
            fl_out.write(str.getBytes(StandardCharsets.UTF_8));
            fl_out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/

        //val jsonList = Json.encodeToString(tasks);

        try
        {
            FileInputStream fl_in = openFileInput("test.txt");
            byte[] bData = fl_in.readAllBytes();
            String s = new String(bData);
            txt.setText(s);
            fl_in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}