package se.iuh.intent_bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnGoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoi = findViewById(R.id.btnGoi);
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("X",113);
                bundle.putDouble("D", 112.115);

                SanPham sp = new SanPham(1,"Red bull", 8000);
                bundle.putSerializable("sanpham",sp);

                intent.putExtra("thisisbundle", bundle);
                startActivity(intent);
            }
        });
    }
}
