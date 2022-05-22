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

public class ConstructorCategoryActivity extends AppCompatActivity {

    private ListView listViewConstructors;

    private ArrayList<Constructor> constructors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructor_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        constructors = new ArrayList<>();
        constructors.add(new Constructor(getString(R.string.constructor_plastic_title), getString(R.string.constructor_plastic_info), R.drawable.logoplastic));
        constructors.add(new Constructor(getString(R.string.constructor_wood_title), getString(R.string.constructor_wood_info), R.drawable.logowood));
        constructors.add(new Constructor(getString(R.string.constructor_magnet_title), getString(R.string.constructor_magnet_info), R.drawable.logomagnet));
        listViewConstructors = findViewById(R.id.listViewConstructors);
        ArrayAdapter<Constructor> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, constructors);
        listViewConstructors.setAdapter(adapter);
        listViewConstructors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Constructor constructor = constructors.get(position);
                Intent intent = new Intent(getApplicationContext(), ConstructorDetailActivity.class);
                intent.putExtra("title", constructor.getTitle());
                intent.putExtra("info", constructor.getInfo());
                intent.putExtra("resId", constructor.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}