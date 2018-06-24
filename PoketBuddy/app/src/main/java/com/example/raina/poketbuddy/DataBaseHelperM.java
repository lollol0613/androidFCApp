package com.example.raina.poketbuddy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Member;

public class DataBaseHelperM extends SQLiteOpenHelper {
    public static final String DB_name = "FMember.db";
    public static final int DB_version = 1;
    public static final String Table_name = "fmember";
    public static String Column_1 = "name";
    public static String Column_2 = "email";
    public static String Column_3 = "contact";
    public static String Column_4 = "id";
    public static String Column_5 = "password";

    public SQLiteDatabase db;
    String result = " ";

    public DataBaseHelperM(Context context, String name, SQLiteDatabase.CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table fmember(name varchar(20), email varchar(20), contact varchar(20), id varchar(20), password varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String q = "drop table if exists " + Table_name;
        db.execSQL(q);
        this.onCreate(db);
    }

    public boolean saver(String name, String email, String contact, String id, String password) {

        Log.e("DataBaseHelper", "Sql");
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(
                "insert into fmember(name,email,contact,id,password) values("
                        + String.format("'%s'", name) + ","
                        + String.format("'%s'", email) + ","
                        + String.format("'%s'", contact) + ","
                        + String.format("'%s'", id) + ","
                        + String.format("'%s'", password) +
                        ");"
        );

        db.close();
        return true;

    }

    public FMember queryPersonById(String id) {

        FMember fmember = new FMember();

        db = this.getReadableDatabase();
        String query = "select * from " + Table_name + " where id='" + id + "'";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                String name = c.getString(0);
                String email = c.getString(1);
                String contact = c.getString(2);
                String id1 = c.getString(3);
                String password = c.getString(4);
                fmember.setName(name);
                fmember.setEmail(email);
                fmember.setContact(contact);
                fmember.setMid(id1);
                fmember.setPassword(password);
                fmember.setstatus(true);
            } while (c.moveToNext());
            c.close();
            fmember.setstatus(false);
            db.close();
        }
        return fmember;
    }
}



