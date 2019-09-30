package com.example.student.nguyenhuynhdinhtan_16028101_h73m08;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterCau1 extends BaseAdapter {
    Context context;
    int layout;
    List<Human> humans;

    public AdapterCau1(Context context, int layout, List<Human> humans) {
        this.context = context;
        this.layout = layout;
        this.humans = humans;
    }

    @Override
    public int getCount() {
        return humans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        private TextView txtName;
        private TextView txtNational;
        private TextView txtPrice;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder viewHolder;
        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            v = layoutInflater.inflate(R.layout.custom_layout_cau1, null);
            viewHolder = new ViewHolder();
            viewHolder.txtName = v.findViewById(R.id.txtName);
            viewHolder.txtNational = v.findViewById(R.id.txtNational);
            viewHolder.txtPrice = v.findViewById(R.id.txtPrice);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.txtName.setText(humans.get(i).getName());
        viewHolder.txtNational.setText(humans.get(i).getNational());
        viewHolder.txtPrice.setText(humans.get(i).getPrice());

        Log.d("kiemtra",humans.get(i).getName() + "\n"+humans.get(i).getNational() + "\n"+humans.get(i).getPrice() + "\n");
        return v;
    }
}
