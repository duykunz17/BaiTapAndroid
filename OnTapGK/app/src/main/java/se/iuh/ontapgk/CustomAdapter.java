package se.iuh.ontapgk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private ArrayList<Contact> contacts;
    public CustomAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.contacts = contacts;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvEmail = convertView.findViewById(R.id.tvEmail);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Contact contact = contacts.get(position);
        viewHolder.tvName.setText(contact.getName());
        viewHolder.tvEmail.setText(contact.getEmail());
        viewHolder.tvPhone.setText(contact.getPhone());
        return convertView;
    }

    public class ViewHolder{
        TextView tvName, tvEmail, tvPhone;
    }
}
