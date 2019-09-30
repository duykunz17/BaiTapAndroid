package se.iuh.baitap3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btnNhap;
    private TextView tvKetQua;
    private EditText txtTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTen = findViewById(R.id.txtTen);

        myList = new ArrayList<String>();
        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        list.setAdapter(adapter);

        btnNhap = findViewById(R.id.btnNhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(txtTen.getText()+ "");
                adapter.notifyDataSetChanged();
            }
        });

        // xử lý sự kiện cho list view
        tvKetQua = findViewById(R.id.tvKetQua);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "position: " + i;
                msg += "; value: " +adapterView.getItemAtPosition(i).toString();
                tvKetQua.setText(msg);
            }
        });
    }
}
