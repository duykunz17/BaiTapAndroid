package se.iuh.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinDm;
    EditText editma, editten;
    Button btnNhap;
    ListView lvSp;

    ArrayList<Catalog> arraySpinner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner = null;

    ArrayList<Product> arrayListview = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    private void getWidgetsControl() {
        spinDm = findViewById(R.id.spDanhMuc);
        editma = findViewById(R.id.txtMaSP);
        editten = findViewById(R.id.txtTenSP);
        btnNhap = findViewById(R.id.btnNhapSP);
        lvSp = findViewById(R.id.lvSP);

        adapterSpinner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpinner);

        adapterListview = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, arrayListview);
        lvSp.setAdapter(adapterListview);
    }

    private void fakeDataCatalog() {
        Catalog cat1 = new Catalog("1", "Samsung");
        Catalog cat2 = new Catalog("2","Iphone");
        Catalog cat3 = new Catalog("3", "IPad");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();
    }

    private void addEventsForFormWidgets() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductForCatalog();
            }
        });
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadListProductByCatalog(arraySpinner.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void addProductForCatalog() {
        Product p = new Product();
        p.setId(editma.getText()+"");
        p.setName(editten.getText()+"");
        Catalog c = (Catalog) spinDm.getSelectedItem();
        c.addProduct(p);
        loadListProductByCatalog(c);
    }

    private void loadListProductByCatalog(Catalog c) {
        arrayListview.clear();
        arrayListview.addAll(c.getListProduct());
        adapterListview.notifyDataSetChanged();
    }
}
