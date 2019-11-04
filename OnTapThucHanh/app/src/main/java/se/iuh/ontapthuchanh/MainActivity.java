package se.iuh.ontapthuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtID, edtPsw, edtRole;
    private Button btnInsert, btnSelect, btnDelete, btnUpdate;
    private GridView gv_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtID = findViewById(R.id.editText);
        edtPsw = findViewById(R.id.editText2);
        edtRole = findViewById(R.id.editText3);
        gv_display = findViewById(R.id.gv_display);

        btnInsert = findViewById(R.id.buttonInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

        btnSelect = findViewById(R.id.buttonSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAll();
            }
        });

        btnDelete = findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                delete(id);
            }
        });

        btnUpdate = findViewById(R.id.buttonUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    public void insert(){
        Uri uri = Uri.parse("content://se.iuh.ontapthuchanh.AccountProvider/accounts");
        ArrayList<Account> listAccount = selectAll();
        if(edtID.getText().toString().equals("") || edtPsw.getText().toString().equals("") || edtRole.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Không thêm account được", Toast.LENGTH_SHORT).show();
        }else {
            Account account = new Account();
            account.setAccountid(edtID.getText().toString());
            account.setCredential(edtPsw.getText().toString());
            account.setRole(edtRole.getText().toString());
            if (listAccount.contains(account)){
                Toast.makeText(MainActivity.this, "Trùng mã account", Toast.LENGTH_SHORT).show();
            }else{
                ContentValues values = new ContentValues();
                values.put("accountid", edtID.getText().toString());
                values.put("credential", edtPsw.getText().toString());
                values.put("role", edtRole.getText().toString());
                getContentResolver().insert(uri, values);
                Toast.makeText(MainActivity.this, "Thêm account thành công", Toast.LENGTH_SHORT).show();
                selectAll();
            }
        }
    }

    public ArrayList<Account> selectAll(){
        Uri uri = Uri.parse("content://se.iuh.ontapthuchanh.AccountProvider/accounts");
        Cursor cursor = getContentResolver().query(uri, null, "select * from accounts",null, null);
        ArrayList<Account> list = new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        if(cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            list.add(new Account(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            listString.add(cursor.getString(0));
            listString.add(cursor.getString(1));
            listString.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, listString);
        gv_display.setAdapter(adapter);
        return list;
    }

    public void delete(String id){
        Uri uri = Uri.parse("content://se.iuh.ontapthuchanh.AccountProvider/accounts");
        ArrayList<String> list = new ArrayList<>();
        int delete = getContentResolver().delete(uri, id, null);
        if(edtID.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "ID rỗng không xóa được", Toast.LENGTH_SHORT).show();
        } else{
            if(delete > 0){
                Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                Account account = new Account();
                list.remove(account);
                selectAll();
            }
            else{
                Toast.makeText(MainActivity.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void update(){
        Uri uri = Uri.parse("content://se.iuh.ontapthuchanh.AccountProvider/accounts");
        if(edtID.getText().toString().equals("") || edtPsw.getText().toString().equals("") || edtRole.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "ID rỗng không xóa được", Toast.LENGTH_SHORT).show();
        }else {
            ContentValues values = new ContentValues();
            values.put("credential", edtPsw.getText().toString());
            values.put("role", edtRole.getText().toString());
            int update =  getContentResolver().update(uri, values, edtID.getText().toString(), null);
            if(update > 0){
                Toast.makeText(MainActivity.this, "Update account thành công", Toast.LENGTH_SHORT).show();
                selectAll();
            }
            else{
                Toast.makeText(MainActivity.this, "Update không thành công", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

