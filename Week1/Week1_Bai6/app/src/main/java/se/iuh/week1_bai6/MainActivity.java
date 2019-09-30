package se.iuh.week1_bai6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvArrayNumber, tvResult;
    Button btnRandom, btnXuatXuoi, btnXuatNguoc, btnMin, btnMax, btnSort, btnSumSNT, btnCountSNT;
    Integer[] num = new Integer[5];

    public boolean checkSNT (int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i < (n - 1); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvArrayNumber = findViewById(R.id.tvArrayNumber);
        tvResult = findViewById(R.id.tvResult);
        btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                for (int i=0; i<num.length; i++) {
                    num[i] = random.nextInt(10);
                }
                tvArrayNumber.setText(Arrays.toString(num));
            }
        });

        btnXuatXuoi = findViewById(R.id.btnXuatXuoi);
        btnXuatXuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                for(int i=0; i<num.length; i++){
                    s += num[i] + " ";
                }
                tvResult.setText(s);
            }
        });

        btnXuatNguoc = findViewById(R.id.btnXuatNguoc);
        btnXuatNguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                for(int i = num.length - 1; i>=0; i--) {
                    s += num[i] + " ";
                }
                tvResult.setText(s);
            }
        });

        btnMax = findViewById(R.id.btnMax);
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = Collections.max(Arrays.asList(num));
                tvResult.setText("" + max);
            }
        });

        btnMin = findViewById(R.id.btnMin);
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int min = Collections.min(Arrays.asList(num));
               tvResult.setText("" + min);
            }
        });

        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                Arrays.sort(num);
                for (int i=0; i<num.length; i++){
                    s += num[i] + " ";
                }
                tvResult.setText(s);
            }
        });

        btnSumSNT = findViewById(R.id.btnSumSNT);
        btnSumSNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                for(int i=0; i<num.length; i++){
                    if(checkSNT(num[i])==true){
                        sum += num[i];
                    }
                }
                tvResult.setText("" + sum);
            }
        });

        btnCountSNT = findViewById(R.id.btnCountSNT);
        btnCountSNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                for(int i=0; i<num.length; i++){
                    if(checkSNT(num[i])==true){
                        count++;
                    }
                }
                tvResult.setText("" + count);
            }
        });
    }
}
