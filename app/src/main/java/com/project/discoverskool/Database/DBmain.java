package com.project.discoverskool.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class DBmain extends SQLiteOpenHelper {

    public static final String DbNAME = "Schools";
    public static final String TABLENAME = "popularSch";
    public static final int VER = 1;


    public DBmain(@Nullable Context context) {
        super(context, DbNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +TABLENAME+ "(id integer primary key, name text, location text, vacancy text, status text, description text, about text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists "+ TABLENAME+ "";
        db.execSQL(query);

    }
    public Cursor readalldata(){
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from popularSch order by id desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }
    public Cursor readhighdata(){
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from popularSch where about='High' order by id desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }
    public Cursor readprimdata(){
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from popularSch where about='Primary' order by id desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }
    public Cursor readInterndata(){
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from popularSch where about='International' order by id desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }
    public Cursor readTVETSdata(){
        SQLiteDatabase db =this.getReadableDatabase();
        String qry = "select * from popularSch where about='TVET' order by id desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;

    }

}
