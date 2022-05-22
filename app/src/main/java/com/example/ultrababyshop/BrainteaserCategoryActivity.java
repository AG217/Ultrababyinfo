package com.example.ultrababyshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BrainteaserCategoryActivity extends AppCompatActivity {

    private ListView listViewBrains;

    private ArrayList<Brain> brains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainteaser_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        brains = new ArrayList<>();
        brains.add(new Brain(getString(R.string.brain_mechanical_title), getString(R.string.brain_mechanical_info), R.drawable.logomechanical));
        brains.add(new Brain(getString(R.string.brain_printed_title), getString(R.string.brain_printed_info), R.drawable.printedlogo));
        listViewBrains = findViewById(R.id.listViewBrains);
        ArrayAdapter<Brain> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, brains);
        listViewBrains.setAdapter(adapter);
        listViewBrains.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Brain brain = brains.get(position);
                Intent intent = new Intent(getApplicationContext(), BrainDetailActivity.class);
                intent.putExtra("title", brain.getTitle());
                intent.putExtra("info", brain.getInfo());
                intent.putExtra("resId", brain.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}

