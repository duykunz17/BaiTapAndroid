package com.example.student.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHepler_Author extends SQLiteOpenHelper {
    public DBHepler_Author(Context context) {
        super(context, "author_list", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Author (id integer primary key, "+" name text, address text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Author");
        onCreate(db);
    }

    // Thêm tác giả
    public boolean insertAuthor(Author author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", author.getId());
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());
        db.insert("Author", null, contentValues);
        return true;
    }

    // Lấy tác giả theo id
    public Author getAuthor(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Author where id = " + id, null);
        if(cursor != null)
            cursor.moveToFirst();
        Author author = new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        return author;
    }

    // lấy ra tất cả các tác giả trong SQL
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Author", null);
        if(cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    // Xóa tác giả theo ID
    public boolean deleteAuthor (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("delete from Author where id = " + id, null);
        if (cursor == null)
            return false;
        else {
            cursor.moveToFirst();
            cursor.close();
        }
        return true;
    }

    // Cập nhật lại tác giả
    public boolean updateAuthor(int id, String name, String address, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address",address);
        contentValues.put("email", email);
        db.update("Author",contentValues, "id = " + id,null);
        return true;
    }
}
