package iuh.exercise.andy.kiemtra;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Student student = (Student) bundle.getSerializable("student");
        FragmentManager fragmentManager = getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.fragDetail);
        if (detailFragment != null && detailFragment.isAdded()) {
            detailFragment.applyData(student);
        }
    }
}
