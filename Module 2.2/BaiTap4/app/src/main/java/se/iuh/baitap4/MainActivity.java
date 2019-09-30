package se.iuh.baitap4;

import android.app.ListActivity;
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

public class MainActivity extends ListActivity {
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

        //list = findViewById(R.id.list);
        txtTen = findViewById(R.id.txtTen);

        tvKetQua = findViewById(R.id.tvKetQua);

        myList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        setListAdapter(adapter);

        btnNhap = findViewById(R.id.btnNhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(txtTen.getText()+ "");
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String)getListAdapter().getItem(position);
        tvKetQua.setText("position: " + position + "; value:" + item + "");
    }
}

