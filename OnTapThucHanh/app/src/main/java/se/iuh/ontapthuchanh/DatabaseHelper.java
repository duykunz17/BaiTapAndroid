package se.iuh.ontapthuchanh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// lớp thao tác với csdl
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "accountsdb";
    static final String TABLE_NAME = "accounts";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE " + TABLE_NAME
            + " (accountid varchar(30) primary key,"
            + " credential varchar(30) not null,"
            + " role varchar(20) not null default 'guest' )";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
        ContentValues values = new ContentValues();
        values.put("accountID", "VoVanHai");
        values.put("credential", "123");
        values.put("role", "admin");
        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

