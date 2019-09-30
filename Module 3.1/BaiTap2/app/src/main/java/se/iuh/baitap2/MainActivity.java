package se.iuh.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShowContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowContext = findViewById(R.id.btnShowContext);
        registerForContextMenu(btnShowContext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.itemRed){
            btnShowContext.setTextColor(getResources().getColor(R.color.clrred));
        }
        else if(item.getItemId()==R.id.itemGreen){
            btnShowContext.setTextColor(getResources().getColor(R.color.clrgreen));
        }
        else if(item.getItemId()==R.id.itemBlue){
            btnShowContext.setTextColor(getResources().getColor(R.color.clrblue));
        }
        return super.onContextItemSelected(item);
    }
}
