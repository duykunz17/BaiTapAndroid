package se.iuh.contentprovider2table;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// lớp cung cấp nội dung sẽ cung cấp
public class BookProvider extends ContentProvider {
    static final String TAG = "AccountProvider";
    static final String AUTHORITY = "content://se.iuh.contentprovider2table.BookProvider/accounts";
    static final Uri CONTENT_URI = Uri.parse(AUTHORITY);
    static final String TABLE_NAME = "accounts";
    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        if(db!=null) return true;
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = db.rawQuery(selection, null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        String ret = getContext().getContentResolver().getType(Settings.System.CONTENT_URI);
        Log.d(TAG, "getType returning: " + ret);
        return ret;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowID = db.insert(TABLE_NAME, "", values);
        if(rowID > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            Log.d("Thêm thành công", "nè");
            return _uri;
        }
        throw new SQLException("Failed to add a record into" + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        count = db.delete(TABLE_NAME,  "accountID = '"+selection+"'" , selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        count = db.update(TABLE_NAME, values, "accountID = '"+selection+"'" , selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
