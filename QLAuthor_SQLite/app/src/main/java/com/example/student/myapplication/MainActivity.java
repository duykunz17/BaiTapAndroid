package com.example.student.myapplication;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_name, et_address, et_email;
    Button bt_save, bt_select, bt_update, bt_delete, bt_exit;
    GridView gv_display;
    DBHepler_Author dbHelper;
    ArrayList<Author> listAuthor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tttg:
                showDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(){
        Dialog dialog = new Dialog(this, android.R.style.Theme_Light);
        dialog.setTitle("Thong Tin Tác Giả");
        dialog.setContentView(R.layout.dialog_main);
        et_id = (EditText) dialog.findViewById(R.id.editTextID);
        et_name = (EditText) dialog.findViewById(R.id.editTextName);
        et_address = (EditText)dialog.findViewById(R.id.editTextAddress);
        et_email = (EditText)dialog.findViewById(R.id.editTextEmail);

        gv_display = (GridView) dialog.findViewById(R.id.gridView_listItem);

        dbHelper = new DBHepler_Author(this);

        bt_save = (Button) dialog.findViewById(R.id.buttonSave);
        bt_select = (Button) dialog.findViewById(R.id.buttonSelect);
        bt_exit = (Button) dialog.findViewById(R.id.buttonExit);
        bt_delete = (Button) dialog.findViewById(R.id.buttonDelete);
        bt_update = (Button) dialog.findViewById(R.id.buttonUpdate);
        eventHandler();

        listAuthor = dbHelper.getAllAuthor();

        dialog.show();
    }

    public void eventHandler(){
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(et_id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_address.getText().toString());

                // kiểm tra trùng
                if (listAuthor.contains(author))
                    Toast.makeText(MainActivity.this, "Trùng mã", Toast.LENGTH_SHORT).show();
                else {
                    if (dbHelper.insertAuthor(author)) {
                        listAuthor.add(author);
                        Toast.makeText(MainActivity.this, "Thêm tác giả thành công", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                ArrayList<Author> authorlist = new ArrayList<>();
                authorlist = dbHelper.getAllAuthor();
                for (Author a: authorlist){
                    list.add(a.getId() + "");
                    list.add(a.getName());
                    list.add(a.getAddress());
                    list.add(a.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                gv_display.setAdapter(adapter);
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(et_id.getText().toString());
                if(dbHelper.deleteAuthor(id)){
                    ArrayList<String> list = new ArrayList<>();
                    ArrayList<Author> authorlist = new ArrayList<>();
                    authorlist = dbHelper.getAllAuthor();
                    for (Author a: authorlist){
                        list.add(a.getId() + "");
                        list.add(a.getName());
                        list.add(a.getAddress());
                        list.add(a.getEmail());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                    gv_display.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Xóa tác giả thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Xóa tác giả không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();
                String name = et_name.getText().toString();
                String address = et_address.getText().toString();
                String email = et_email.getText().toString();
                if(!id.isEmpty()){
                    dbHelper.updateAuthor(Integer.parseInt(id), name, address, email);
                    Toast.makeText(getApplicationContext(), "Cập nhật tác giả thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Cập nhật tác giả không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
