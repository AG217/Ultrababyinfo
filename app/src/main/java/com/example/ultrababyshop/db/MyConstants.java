package com.example.ultrababyshop.db;

public class MyConstants {
    public static final String TABLE_NAME = "my_table";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String DB_NAME = "reviews.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STR = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + DESCRIPTION +
            " TEXT)";
    public static final String DROP_TABLE =" DROP TABLE IF EXISTS " + TABLE_NAME;
}
