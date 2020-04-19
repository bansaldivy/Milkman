package com.example.milkman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "CREATE_ACCOUNT_DATABASE";
    private static final String TABLE_NAME1 = "CART";
    private static final String COL1 = "NAME";
    private static final String COL2 = "MOBILE_NUMBER";
    private static final String COL3 = "PASSWORD";
    private static final String COL4 = "EMAIL";

    private static final String TAG = "DATABASECREATEACCOUNT";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (NAME TEXT,MOBILE_NUMBER TEXT,PASSWORD TEXT,EMAIL TEXT )";
        String createTable1 = "CREATE TABLE " + TABLE_NAME1 + "(PRICE TEXT,TITLE TEXT)";
        db.execSQL(createTable1);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean CheckAvailability(String fieldValue) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String Query = "Select * from " + TABLE_NAME + " where " + COL2 + " = '" + fieldValue + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(Query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
            //No Data Matching
        }
        cursor.close();
        return true;
        //Data Matching
    }

    public boolean login(String mob, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "Select * from " + TABLE_NAME + " where " + COL2 + " = '" + mob + "' and " + COL3 + "='" + pass + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
            //Login fails
        }
        cursor.close();
        return true;
        //Success
    }

    public int insertData(String name, String mno, String password, String Referral) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, name);
        contentValues.put(COL2, mno);
        contentValues.put(COL3, password);
        contentValues.put(COL4, Referral);
        long result = 0;

        if (!CheckAvailability(mno)) {
            result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 100;
        }

    }
}


