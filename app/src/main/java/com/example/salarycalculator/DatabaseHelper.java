package com.example.salarycalculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.salarycalculator.UsersTable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "NameOfDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ UsersTable.TABLE_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name TEXT, "+
                "surname TEXT, "+
                "personal_no TEXT, "+
                "email TEXT, "+
                "password TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+UsersTable.TABLE_NAME);
        onCreate(db);
    }

}
