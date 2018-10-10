package com.example.a1.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A1 on 07-Oct-18.
 */

public class DB_App extends SQLiteOpenHelper {
    public  static final String DB_Name ="firstDB";
    public DB_App(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE MyUsers ( id INT AUTOINCREMENT PRIMARY KEY, firstname VARCHAR(30) , lastname VARCHAR(30) , email VARCHAR(50), pass VARCHAR(50))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="ROP TABLE IF EXISTS MyUsers";
        db.execSQL(query);
        onCreate(db);
    }
    public boolean insertData(String firstname, String lastname,String email,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("email",email);
        contentValues.put("pass",pass);
        long result = db.insert("MyUsers",null,contentValues);
        if(result == -1){
            return  false;
        }
        else {
            return true;
        }
    }
    public int getOneRow(String email,String pass){
        SQLiteDatabase db= this.getReadableDatabase();

//        String k = email;
//        String p = pass;
//        email ="aaa@yahoo.com";
//        pass="123";

//        db.query(tableName, null, "email = ?", new String[]{email}, null, null, null);
//        Cursor cr =        db.query(tableName, null, "email = ?", new String[]{email}, null, null, null);
        String tableName="MyUsers";
        String query = "select * from " + tableName + " where "+ "email" + " = '" + email + "'" + " and "+ " pass" + " = '" + pass + "'";
        Cursor cr2 = db.rawQuery(query,null);
        int s = cr2.getCount();
        return cr2.getCount();

    }
}
