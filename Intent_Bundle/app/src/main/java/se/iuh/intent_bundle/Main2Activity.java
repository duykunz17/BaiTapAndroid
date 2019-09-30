package se.iuh.intent_bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtKQ = findViewById(R.id.txtKQ);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("thisisbundle");

        SanPham sp = (SanPham) bundle.getSerializable("sanpham");

        txtKQ.setText("X=" +bundle.getInt("X")+ "\n"+
                      "D=" +bundle.getDouble("D")+ "\n"+
                      "SP=" +sp);
    }
}
