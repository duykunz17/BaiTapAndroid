package com.example.student.baitap1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUocSo, btnThoat;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtResult = findViewById(R.id.txtResult);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUocSo = findViewById(R.id.btnUocSo);
        btnThoat = findViewById(R.id.btnThoat);
    }

    private void addEvents() {
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int kq = a+b;
                txtResult.setText(kq+"");
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int kq = a-b;
                txtResult.setText(kq+"");
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int kq = a*b;
                txtResult.setText(kq+"");
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                double kq = a*1.0/b;
                txtResult.setText(kq+"");
            }
        });

        btnUocSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int kq = uocSoChungLonNhat(a,b);
                txtResult.setText(kq+"");
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private int uocSoChungLonNhat(int a, int b) {
        // Nếu a = 0 => ucln(a,b) = b
        // Nếu b = 0 => ucln(a,b) = a
        if (a == 0 || b == 0){
            return a + b;
        }
        while (a != b){
            if (a > b){
                a -= b; // a = a - b
            }else{
                b -= a;
            }
        }
        return a; // return a or b, bởi vì lúc này a và b bằng nhau
    }

}
