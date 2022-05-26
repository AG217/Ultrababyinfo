package com.example.ultrababyshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ultrababyshop.db.MyDbManager;

public class MainActivity extends AppCompatActivity {

    private ListView listViewToys;
    private MyDbManager myDbManager;
    private EditText edName, edDesc;
    private TextView tvText;
    private Button buttonFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbManager = new MyDbManager(this);
        edName = findViewById(R.id.editTextName);
        edDesc = findViewById(R.id.editTextDescription);
        tvText = findViewById(R.id.textViewFeedBack);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        buttonFeedBack = findViewById(R.id.buttonFeedBack);
        buttonFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setText("");
                myDbManager.insertToDb(edName.getText().toString().trim(), edDesc.getText().toString().trim());
                for (String name : myDbManager.getFromDb()) {
                    tvText.append(name);
                    tvText.append("\n");

                }
                edName.getText().clear();
                edDesc.getText().clear();
            }
        });

        listViewToys = findViewById(R.id.listViewToys);
        listViewToys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getApplicationContext(), ConstructorCategoryActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getApplicationContext(), SoftCategoryActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(), BrainteaserCategoryActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
        for (String name : myDbManager.getFromDb()) {
            tvText.append(name);
            tvText.append("\n");
        }
    }

//    public void onClickSave(View view) {
//        tvText.setText("");
//            myDbManager.insertToDb(edName.getText().toString().trim(), edDesc.getText().toString().trim());
//            for (String name : myDbManager.getFromDb()) {
//                tvText.append(name);
//                tvText.append("\n");
//
//            }
//            edName.getText().clear();
//            edDesc.getText().clear();
//    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDb();
    }
}