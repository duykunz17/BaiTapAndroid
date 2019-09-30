package se.iuh.week1_bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etLength, etWidth;
    Button btnS, btnP;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLength = findViewById(R.id.etLength);
        etWidth =  findViewById(R.id.etWidth);
        btnS = findViewById(R.id.btnS);
        btnP = findViewById(R.id.btnP);
        tvResult = findViewById(R.id.tvResult);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double length = Double.parseDouble(etLength.getText().toString());
                double width = Double.parseDouble(etWidth.getText().toString());
                double s = length*width;
                tvResult.setText("Result: " + s);
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double length = Double.parseDouble(etLength.getText().toString());
                double width = Double.parseDouble(etWidth.getText().toString());
                double p = (length+width)*2;
                tvResult.setText("Result: " + p);
            }
        });
    }
}
