package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Cau1 extends AppCompatActivity {
    ListView lv;
    List<Human> humans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cau1);
        lv = findViewById(R.id.lv);
        humans = new ArrayList<>();
        humans.add(new Human("Người Sắt", "Viet Nam", "20000"));
        humans.add(new Human("Người Khổng Lồ Xanh   " ,"Taipei","20000"));
        humans.add(new Human("Người Sắt 2" ,"China","4300000"));
        humans.add(new Human("Thor " ,"UK","200000"));
        humans.add(new Human("Captain America" ,"USA","500000"));
        humans.add(new Human("Natilus" ,"JP","400000"));
        humans.add(new Human("Jesus" ,"Russia ","400000"));


        humans.add(new Human("Người Sắt", "Viet Nam", "20000"));
        humans.add(new Human("Người Khổng Lồ Xanh   " ,"Taipei","20000"));
        humans.add(new Human("Người Sắt 2" ,"China","4300000"));
        humans.add(new Human("Thor " ,"UK","200000"));
        humans.add(new Human("Captain America" ,"USA","500000"));
        humans.add(new Human("Natilus" ,"JP","400000"));
        humans.add(new Human("Jesus" ,"Russia ","400000"));
        AdapterCau1 adapterCau1 = new AdapterCau1(Activity_Cau1.this, R.layout.custom_layout_cau1,humans );
        lv.setAdapter(adapterCau1);
        adapterCau1.notifyDataSetChanged();

    }
}

