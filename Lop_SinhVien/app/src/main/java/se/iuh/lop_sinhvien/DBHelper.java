package se.iuh.lop_sinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    DBHelper(Context context){
        super(context,  "SVDB.sqlite",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists Lop(id integer primary key autoincrement, "+" name text)");
        sqLiteDatabase.execSQL("create table if not exists SV(id integer primary key autoincrement, "+" name text, classname text, subject text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean InsertLop(Lop lop, String tablename){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", lop.getName());
        db.insert(tablename+"",null, contentValues);
        return true;
    }
    public boolean UpdateSV(int id ,SinhVien sv, String tablename){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", sv.getSubject());
        contentValues.put("name", sv.getName());
        contentValues.put("classname", sv.getClassname());
        db.update(tablename+"", contentValues, "id=" +id, null);
        return true;
    }
    public boolean Insert(SinhVien sv, String tablename){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", sv.getSubject());
        contentValues.put("name", sv.getName());
        contentValues.put("classname", sv.getClassname());
        db.insert(tablename+"",null, contentValues);
        return true;
    }
    public SinhVien get(int id, String tablename){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + tablename + " where id= " + id,null);
        if(cursor != null)  cursor.moveToFirst();
        SinhVien sv =
                new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        db.close();
        return sv;

    }
    public ArrayList<SinhVien> getAll(String tablename){
        ArrayList<SinhVien> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " +tablename, null);
        if(cursor != null) cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            list.add(new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;

    }
    public boolean delete(int id, String tablename){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("delete from "+ tablename+" where id=" + id,null);
        if(cursor != null)  cursor.moveToFirst();
        cursor.close();
        db.close();
        return true;

    }

}


