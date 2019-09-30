package se.iuh.readwritefile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTen,editNoiDung;
    private Button btnMo, btnLuu, btnNhap;
    private Spinner spFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = findViewById(R.id.editTen);
        editNoiDung = findViewById(R.id.editNoiDung);
        btnNhap = findViewById(R.id.btnNhap);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTen.setText("");
                editNoiDung.setText("");
            }
        });
        final ArrayList<String> filenamelist = new ArrayList<>();
        filenamelist.add("Hello");

        spFile = findViewById(R.id.spFile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_single_choice,filenamelist);
        spFile.setAdapter(adapter);
        spFile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTen.setText(filenamelist.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnLuu = findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editTen.getText().toString();
                filenamelist.add(filename);
                try {
                        FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
                        fout.write(editNoiDung.getText().toString().getBytes());
                        fout.close();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("myfile",0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("content",editNoiDung.getText().toString());
                    editor.commit();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Lỗi lưu không được", Toast.LENGTH_LONG);
                }

            }
        });
        btnMo = findViewById(R.id.btnMo);
        btnMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editTen.getText().toString();
                StringBuffer buffer = new StringBuffer();
                String line = null;
                try {
                    FileInputStream fin = openFileInput(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while((line = br.readLine())!=null)
                        buffer.append(line).append("\n");
                    editNoiDung.setText(buffer.toString());
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("myfile",0);
                    editNoiDung.setText(pref.getString("content",null));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

