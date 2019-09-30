package com.example.student.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtC, txtF;
    Button btnC, btnF, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        txtC = findViewById(R.id.txtC);
        txtF = findViewById(R.id.txtF);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnClear = findViewById(R.id.btnClear);
    }

    private void addEvents() {
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f = Double.parseDouble(txtF.getText().toString());
                double kq = convertToCelsius(f);
                txtC.setText(kq+"");
            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double c = Double.parseDouble(txtC.getText().toString());
                double kq = convertToFahrenheit(c);
                txtF.setText(kq+"");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtC.setText("");
                txtF.setText("");
            }
        });
    }

    private double convertToFahrenheit(double c) {
        return c*(9*1.0/5) + 32;
    }

    private double convertToCelsius(double f) {
        return (f-32) * (5*1.0/9);
    }
}
