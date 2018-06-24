package com.example.raina.poketbuddy;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import com.example.raina.poketbuddy.Friend;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_name = "Friend.db";
    public static final int DB_version = 1;
    public static final String Table_name = "friend";
    public static String Column_1 = "name";
    public static String Column_2 = "phone";
    public static String Column_3 = "gender";
    public static String Column_4 = "qualification";
    public static String Column_5 = "profession";
    public static String Column_6 = "address";


    public SQLiteDatabase db;
    String result = " ";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table friend(name varchar(20), phone varchar(20), gender varchar(20), qualification varchar(50), profession varchar(20), address varchar(50))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String q = "drop table if exists " + Table_name;
        db.execSQL(q);
        this.onCreate(db);
    }

    public boolean saver(String name, String phone, String gender, String qualification, String profession, String address) {

        Log.e("DataBaseHelper", "Sql");
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(
                "insert into friend(name,phone,gender,qualification,profession,address) values("
                        + String.format("'%s'", name) + ","
                        + String.format("'%s'", phone) + ","
                        + String.format("'%s'", gender) + ","
                        + String.format("'%s'", qualification) + ","
                        + String.format("'%s'", profession) + ","
                        + String.format("'%s'", address) +
                        ");"
        );

        db.close();
        return true;

    }

    public Friend queryPersonByName(String name) {

        Friend friend = new Friend();

        db = this.getReadableDatabase();
        String query = "select * from " + Table_name + " where name='" + name + "'";

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                String un1 = c.getString(0);
                String phone = c.getString(1);
                String genders = c.getString(2);
                String quals = c.getString(3);
                String profs = c.getString(4);
                String addresss = c.getString(5);
                friend.setName(un1);
                friend.setPhone_number(phone);
                friend.setGender(genders);
                friend.setQul(quals);
                friend.setProfession((profs));
                friend.setAddress(addresss);
                friend.setstatus(true);
            } while (c.moveToNext());
            c.close();
            friend.setstatus(false);
            db.close();
        }
        return friend;
    }


    public boolean update_rec(Friend friend, String name1) {

        Log.e("EditFriend","update_rec: "+friend.getName() + " : " + friend.getPhone_number() + " : " + friend.getGender() + " : " + friend.getQul() + " : " + friend.getProfession() + " : " + friend.getAddress() + " : ");
        queryPersonByName(name1);

        db = this.getWritableDatabase();
        String sql = "update friend set name="
                + String.format("'%s'", friend.getName()) + ",phone ="
                + String.format("'%s'", friend.getPhone_number()) + ",gender="
                + String.format("'%s'", friend.getGender()) + ",qualification="
                + String.format("'%s'", friend.getQul()) + ",profession="
                + String.format("'%s'", friend.getProfession()) + ",address="
                + String.format("'%s'", friend.getAddress())
                + " where name='" + name1 + "'";
        db.execSQL(sql);
        db.close();
        return true;
    }


    public boolean delete_rec(String name1) {
        db = this.getWritableDatabase();
        db.execSQL("delete from friend where name = '" + name1 + "'");
        db.close();
        return true;
    }
    public ArrayList<Friend> getAllFriend() {
        ArrayList<Friend> arrayListOfFriend = new ArrayList<Friend>();

        db = this.getReadableDatabase();

        String query = "select * from " + Table_name;
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                String fn = c.getString(0);
                String pno = c.getString(1);
                String add = c.getString(2);

                Friend friend = new Friend();

                friend.setName(fn);
                friend.setPhone_number(pno);
                friend.setAddress(add);
                friend.setstatus(true);

                arrayListOfFriend.add(friend);
            } while (c.moveToNext());
            c.close();
            db.close();
        }
        return arrayListOfFriend;
    }
}



