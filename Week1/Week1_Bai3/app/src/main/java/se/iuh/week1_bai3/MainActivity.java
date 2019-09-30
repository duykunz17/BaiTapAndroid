package se.iuh.week1_bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGiai;
    EditText etA, etB;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        tvResult = findViewById(R.id.tvResult);
        btnGiai = findViewById(R.id.btnGiai);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(etA.getText().toString());
                double b = Double.parseDouble(etB.getText().toString());
                if (a==0){
                    if(b==0){
                        tvResult.setText("Phương trình vô số nghiệm");
                    }
                    else {
                        tvResult.setText("Phương trình vô nghiệm");
                    }
                }
                else{
                    double x = -b*1.0/a;
                    tvResult.setText("Phương trình có 1 nghiệm duy nhất: " +x);
                }
            }
        });
    }
}
