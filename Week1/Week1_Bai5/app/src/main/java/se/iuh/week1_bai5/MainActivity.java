package se.iuh.week1_bai5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etHoTen, etHoLot, etTen;
    TextView tvHoLot, tvTen;
    Button btnXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHoTen = findViewById(R.id.etHoTen);
        etHoLot = findViewById(R.id.etHoLot);
        etTen = findViewById(R.id.etTen);
        btnXuat = findViewById(R.id.btnXuat);
        btnXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = etHoTen.getText().toString();
                String[] ten = s.split(" ");
                String holot = "";
                etTen.setText(ten[ten.length-1]);
                for (int i=0; i<ten.length-1; i++){
                    holot+=ten[i] + " ";
                }
                etHoLot.setText(holot);
            }
        });
    }
}
