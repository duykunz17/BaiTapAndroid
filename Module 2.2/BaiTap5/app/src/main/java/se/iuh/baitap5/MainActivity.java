package se.iuh.baitap5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editId, editName;
    Button btnNhap;
    RadioGroup radGroup;
    RadioButton radioButton;
    ListView lvDanhSach;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter = null;

    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.txtMaNV);
        editName = findViewById(R.id.txtTenNV);
        btnNhap = findViewById(R.id.btnNhap);
        radGroup = findViewById(R.id.radGroup);
        //radCT = findViewById(R.id.radCT);
        //radTV = findViewById(R.id.radTV);
        lvDanhSach = findViewById(R.id.list);

        arrayAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvDanhSach.setAdapter(arrayAdapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();
            }
        });
    }

    private void nhap() {
        int radId = radGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radId);
        String id = editId.getText() + "";
        String name = editName.getText() + "";
        if(radId == R.id.radCT)
        {
            employee = new EmployeeFullTime();
        }
        else if (radId == R.id.radTV)
        {
            employee = new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);

        arrEmployee.add(employee);
        arrayAdapter.notifyDataSetChanged();
    }
}

