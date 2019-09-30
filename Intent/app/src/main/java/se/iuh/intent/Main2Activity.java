package se.iuh.intent;

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
        boolean kieuBoolean = intent.getBooleanExtra("kieu_boolean", false);
        char kieuChar = intent.getCharExtra("kieu_char", 'w');
        int kieuInt = intent.getIntExtra("kieu_int", 0);
        double kieuDouble = intent.getDoubleExtra("kieu_double", 0.0);
        String kieuChuoi = intent.getStringExtra("kieu_chuoi");

        SinhVien sv = (SinhVien) intent.getSerializableExtra("sinhvien");

        txtKQ.setText("Kiểu boolean = " +kieuBoolean+ "\n" +
                      "Kiểu char = " +kieuChar+ "\n" +
                      "Kiểu int = " +kieuInt+ "\n" +
                      "Kiểu double = " +kieuDouble+ "\n" +
                      "Kiểu chuỗi = " +kieuChuoi+ "\n"+
                      "Kiểu object: \n" +
                      "Mã: " +sv.getMa()+ "\n" +
                      "Tên: " +sv.getTen());
    }
}
