package com.example.ultrababyshop.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.ultrababyshop.R;

import java.util.ArrayList;
import java.util.List;

public class MyDbManager {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        myDbHelper = new MyDbHelper(context);

    }
    public void openDb(){
        db = myDbHelper.getWritableDatabase();
    }
    public void insertToDb(String name, String description){
        if (isFilled(name, description)) {
            ContentValues cv = new ContentValues();
            cv.put(MyConstants.NAME, name);
            cv.put(MyConstants.DESCRIPTION, description);
            db.insert(MyConstants.TABLE_NAME, null, cv);
        } else {
            Toast.makeText(context, R.string.warning_name_empty, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFilled(String name, String description) {
        return !name.isEmpty() && !description.isEmpty();
    }

    public List<String> getFromDb(){
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null ,null, null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(MyConstants.NAME));
            @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(MyConstants.DESCRIPTION));

            tempList.add(name);
            tempList.add(description);
        }
        cursor.close();
        return tempList;
    }
    public void closeDb(){
        myDbHelper.close();
    }
}
