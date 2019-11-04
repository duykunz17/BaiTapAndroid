package se.iuh.contentprovider2table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    DatabaseHelper dbHelper;
    ArrayList<Author> listAuthor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.editTextID);
        et_name = (EditText) findViewById(R.id.editTextName);
        et_address = (EditText)findViewById(R.id.editTextAddress);
        et_email = (EditText)findViewById(R.id.editTextEmail);

        gv_display = (GridView) findViewById(R.id.gridView_listItem);

        dbHelper = new DatabaseHelper(this);

        bt_save = (Button) findViewById(R.id.buttonSave);
        bt_select = (Button) findViewById(R.id.buttonSelect);
        bt_exit = (Button) findViewById(R.id.buttonExit);
        bt_delete = (Button) findViewById(R.id.buttonDelete);
        bt_update = (Button) findViewById(R.id.buttonUpdate);
        eventHandler();
        listAuthor = dbHelper.getAllAuthor();
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
