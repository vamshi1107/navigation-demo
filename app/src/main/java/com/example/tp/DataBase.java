package com.example.tp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "Simple database";
    private static final String TABLE_NAME = "simple";
    private static int version = 1;
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_PHONE = "Phone";

    public DataBase(Context context) {
        super(context, DB_NAME, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT, " + KEY_PHONE + " TEXT" + ")";
        db.execSQL(s);
        Log.d("db", "created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void ADD(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, contacts.getName());
        cv.put(KEY_PHONE, contacts.getPhone());
        db.insert(TABLE_NAME, null, cv);
        Log.d("db", "inserted");
        db.close();
    }

    public List<Contacts> getCon() {
        List<Contacts> cl = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sel = "SELECT * FROM " + TABLE_NAME;
        Cursor cur = db.rawQuery(sel, null);
        if (cur.moveToFirst()) {
            do {
                Contacts con = new Contacts();
                con.setId(Integer.parseInt(cur.getString(0)));
                con.setName(cur.getString(1));
                con.setPhone(cur.getString(2));
                cl.add(con);
            } while (cur.moveToNext());

    }
        return cl;
    }
}

