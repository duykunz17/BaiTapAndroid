package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KetQuaCau2 extends AppCompatActivity {
    TextView txtKetQua;
    Button btnCallActivityCau2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_layout_cau2);
        btnCallActivityCau2=findViewById(R.id.btnCallActivityCau2);
        txtKetQua=findViewById(R.id.txtKetQua);
        Intent intent =getIntent();
        String kq=intent.getStringExtra("kq");
        txtKetQua.setText(kq);
        btnCallActivityCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KetQuaCau2.this,Activity_Cau2.class);
                startActivity(intent);
            }
        });
    }
}
