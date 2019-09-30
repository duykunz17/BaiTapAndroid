package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Cau2 extends AppCompatActivity {
    Float a, b, c;

    Button btnKetQua;
    EditText edA, edB, edC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cau2);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);
        btnKetQua = findViewById(R.id.btnKetQua);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Float.parseFloat(edA.getText().toString());
                b = Float.parseFloat(edB.getText().toString());
                c = Float.parseFloat(edB.getText().toString());
                String kq = GiaiPhuongTrinhBac2(a, b, c);
                Intent intent = new Intent(Activity_Cau2.this, KetQuaCau2.class);
                intent.putExtra("kq", kq);
                startActivity(intent);
            }
        });
    }

    public String GiaiPhuongTrinhBac2(float a, float b, float c) {
        String resuilt = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    resuilt = "Phương trình có vô số nghiệm";
                } else {
                    resuilt = " Phương trình vô nghiệm";
                }
            } else {
                return ("Phương trình có nghiệm duy nhất  : " + (-c / b));
            }
        } else {
            float delda = (b * b) - (4 * a * c);
            if (delda < 0) {
                resuilt = " Phương trình vô nghiệm";
            } else if (delda == 0) {
                resuilt = ("Phương trình có nghiệm kép" + -b / (2 * a));
            } else {
                resuilt = "Phương trình có  2 nghiệm phân biệt x1 = " + (-b + Math.sqrt(delda) / (2 * a)) + " và x2 = " + (-b - Math.sqrt(delda) / (2 * a));
            }
        }
        return resuilt;
    }
}
