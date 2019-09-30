package iuh.exercise.andy.kiemtra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {
    private TextView tvName,tvEmail,tvAddress,tvYear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvYear = view.findViewById(R.id.tvYear);
        return view;
    }

    public void applyData(Student student) {
        tvName.setText(student.getName());
        tvYear.setText(student.getYear() + "");
        tvEmail.setText(student.getEmail());
        tvAddress.setText(student.getAddress());
    }

}
