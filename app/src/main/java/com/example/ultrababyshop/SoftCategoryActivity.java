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

public class SoftCategoryActivity extends AppCompatActivity {

    private ListView listViewSofts;

    private ArrayList<Soft> softs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        softs = new ArrayList<>();
        softs.add(new Soft(getString(R.string.soft_interactive_title), getString(R.string.soft_interactive_info), R.drawable.logointeractive));
        softs.add(new Soft(getString(R.string.soft_classic_title), getString(R.string.soft_classic_info), R.drawable.logosoft));
        listViewSofts = findViewById(R.id.listViewSofts);
        ArrayAdapter<Soft> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, softs);
        listViewSofts.setAdapter(adapter);
        listViewSofts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Soft soft = softs.get(position);
                Intent intent = new Intent(getApplicationContext(), SoftDetailActivity.class);
                intent.putExtra("title", soft.getTitle());
                intent.putExtra("info", soft.getInfo());
                intent.putExtra("resId", soft.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}