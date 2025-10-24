package com.example.test_pptr;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

    super(context, "Test", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){db.execSQL("CREATE TABLE datas(name text, lastname text)");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    public String save (String tempname, String templastname){
        String message = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues container = new ContentValues();
        container.put("name", tempname);
        container.put("lastname", templastname);

        try{
            database.insertOrThrow("datas", null, container);
            message = "Data added perfectly";
        }
        catch(SQLException e){
            message = "The data can't be added";
        }
        database.close();
        return message;
    }

    public String[] search_reg(String search){
        String[] datas = new String[3];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datas WHERE name = '" + search +"'";
        @SuppressLint("Recycle") Cursor registers = database.rawQuery(q, null);
        if(registers.moveToFirst()){
            for(int x = 0; x<2; x++){
                {datas[x] = registers.getString(x);}
                datas[2] = "Find it";
            }
        }
        else{datas[2] = "Not find";}
        database.close();
        return datas;
    }

}
