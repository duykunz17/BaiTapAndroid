package com.example.student.internalstorage;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave, btnDisplay;
    EditText myInputText;
    TextView responseText;

    // tên file được tạo
    private String filename = "internalStorage.txt";

    // thư mục do mình đặt
    private String filepath = "ThuMucCuaToi";
    File myInternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        // tạo hoặc mở file nếu nó đã tồn tại trong bộ nhớ trong
        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory, filename);
        // gọi hàm initView
    }

    private void initView() {
        myInputText = findViewById(R.id.myInputText);
        responseText = findViewById(R.id.responseText);
        // các sự kiện
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String myData = "";
        switch (view.getId()){
            case R.id.btnSave:
                try{
                    // mở file
                    FileOutputStream fos = new FileOutputStream(myInternalFile);
                    fos.write(myInputText.getText().toString().getBytes());
                    fos.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                myInputText.setText("");
                responseText.setText("Đã được lưu vào bộ nhớ trong");
                break;

            case R.id.btnDisplay:
                try{
                    // đọc file
                    FileInputStream fis = new FileInputStream(myInternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    // đọc từng dòng
                    while ((strLine = br.readLine()) != null){
                        myData = myData + strLine;
                    }
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                myInputText.setText(myData);
                responseText.setText("Lấy dữ liệu từ bộ nhớ trong");
                break;
        }
    }
}

// Note: để xem file được tạo ra ta vào:
// View -> Tool Windows -> Device File Explorer -> data/data/app ta tạo ra/thư mục vừa tạo/file vừa tạo

