package se.iuh.lop_sinhvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtClassname, edtSubject, edtID;
    Button btnSave, btnDel, btnClear, btnSelect, btnUpdate;
    GridView gvDisplay;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edtID = ((EditText)findViewById(R.id.edtID));
        edtName = (EditText) findViewById(R.id.edtName);
        edtClassname= (EditText)findViewById(R.id.edtClassname);
        edtSubject = (EditText)findViewById(R.id.edtSubject);
        btnDel = (Button)findViewById(R.id.btnDel);
        btnSelect = (Button)findViewById(R.id.btnSelect);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnSave = (Button)findViewById(R.id.btnSave);
        gvDisplay = (GridView) findViewById(R.id.gvDisplay);
        dbHelper = new DBHelper(this);
        dbHelper.InsertLop(new Lop("DHKTPM12A"), "Lop");
        dbHelper.InsertLop(new Lop("DHKTPM12B"), "Lop");
        dbHelper.Insert(new SinhVien("Hieu", "DHKTPM12A", "Android"), "SV");
        dbHelper.Insert(new SinhVien("Ky", "DHKTPM12A", "Android"), "SV");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.setName(edtName.getText().toString());
                sv.setClassname(edtClassname.getText().toString());
                sv.setSubject(edtSubject.getText().toString());

                if(dbHelper.Insert(sv,"SV")){
                    loadData();
                    Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Not Ok", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                ArrayList<SinhVien> svList = new ArrayList<>();
                svList = dbHelper.getAll("SV");
                for(SinhVien b : svList){
                    list.add(b.getId() + "");
                    list.add(b.getName());
                    list.add(b.getClassname());
                    list.add(b.getSubject());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                gvDisplay.setAdapter(adapter);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.UpdateSV(Integer.parseInt(edtID.getText().toString()),new SinhVien(edtName.getText().toString(), edtClassname.getText().toString(), edtSubject.getText().toString()), "SV");
                loadData();
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có xóa không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dbHelper.delete(Integer.parseInt(edtID.getText().toString()),"SV"))
                        {
                            loadData();
                            Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Not Ok", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        gvDisplay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i%4 == 0){
                    int id = Integer.parseInt(adapterView.getItemAtPosition(i).toString());

                    SinhVien b = dbHelper.get(id, "SV");
//                    edtID.setVisibility(View.VISIBLE);

                    edtName.setText(b.getName());
                    edtClassname.setText(b.getClassname());
                    edtSubject.setText(b.getSubject());
                    edtID.setText(b.getId()+"");
                }
                else{
                    Toast.makeText(MainActivity.this,  "Vui lòng chọn ID", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtID.setText("");
                edtName.setText("");
                edtClassname.setText("");
                edtSubject.setText("");
            }
        });
    }
    private void loadData(){
        ArrayList<String> list = new ArrayList<>();
        ArrayList<SinhVien> bookList = new ArrayList<>();
        bookList = dbHelper.getAll("SV");
        for(SinhVien b : bookList){
            list.add(b.getId() + "");
            list.add(b.getName());
            list.add(b.getClassname());
            list.add(b.getSubject());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        gvDisplay.setAdapter(adapter);
    }
}

