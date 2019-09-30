package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnCau1,btnCau2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCau1=findViewById(R.id.btnBai1);
        btnCau2=findViewById(R.id.btnBai2);
        btnCau1.setOnClickListener(this);
        btnCau2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBai1:
                Intent intent1=new Intent(MainActivity.this,Activity_Cau1.class);
                startActivity(intent1);
                break;
            case R.id.btnBai2:
                Intent intent2=new Intent(MainActivity.this,Activity_Cau2.class);
                startActivity(intent2);
                break;
        }

    }
}
