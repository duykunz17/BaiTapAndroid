package se.iuh.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("kieu_boolean", true);
        intent.putExtra("kieu_char", 'x');
        intent.putExtra("kieu_int", 100);
        intent.putExtra("kieu_double", 1.99);
        intent.putExtra("kieu_chuoi", "Trinh Duc Duy");

        SinhVien sv = new SinhVien(16018731, "Duc Duy Trinh");
        intent.putExtra("sinhvien", sv);

        startActivity(intent);
    }
}
