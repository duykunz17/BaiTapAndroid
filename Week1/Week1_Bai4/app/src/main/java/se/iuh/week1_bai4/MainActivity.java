package se.iuh.week1_bai4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etN;
    Button btnIn;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etN = findViewById(R.id.etN);
        tvResult = findViewById(R.id.tvResult);
        btnIn = findViewById(R.id.btnIn);
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int n = Integer.parseInt(etN.getText().toString());
               String s = "";
               for (int i=1; i<=10; i++){
                   s+= (n + "x" + i + " = " + (i * n) + "\n");
               }
               tvResult.setText(s);
            }
        });
    }
}
