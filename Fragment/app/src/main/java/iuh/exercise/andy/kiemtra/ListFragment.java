package iuh.exercise.andy.kiemtra;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends android.support.v4.app.ListFragment {
    private ArrayList<Student> students;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        students = new ArrayList<>();
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        students.add(new Student("Andy", "annguyen3520@gmail.com", "Saigon", 1997));
        CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.custom_listview, students);
        setListAdapter(adapter);
        return view;
    }

    public void openDetailActivity(Student student) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public void sendDataLanscapeMode(Student student) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.fragDetail);
        detailFragment.applyData(student);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int orent = getResources().getConfiguration().orientation;
        if (orent == Configuration.ORIENTATION_LANDSCAPE) {
            sendDataLanscapeMode(students.get(position));
        }else{
            openDetailActivity(students.get(position));
        }
    }
}
