package com.example.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity {

    private ArrayList<String> TODOitems;
    private ArrayAdapter TODOitemsAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        Button back = (Button) findViewById(R.id.secondActivityReturnBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(startIntent);
            }
        });

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        TODOitems = new ArrayList<>();
        TODOitemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TODOitems);
        listView.setAdapter(TODOitemsAdapter);
        setUpViewListener();
    }

    private void setUpViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item removed", Toast.LENGTH_LONG).show();

                TODOitems.remove(i);
                TODOitemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.editTextTextPersonName);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            TODOitemsAdapter.add(itemText);
            input.setText("");
        }
        else
            Toast.makeText(getApplicationContext(), "No empty text allowed!", Toast.LENGTH_LONG).show();
    }
}