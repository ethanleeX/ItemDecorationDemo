package me.masteryi.itemdecorationdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author Ethan Lee
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MyAdapter adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
//                layoutManager.getOrientation());

        MyDividerItemDecoration itemDecoration = new MyDividerItemDecoration(this, layoutManager
                .getOrientation(), false);
        itemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_horizontal));
        recyclerView.addItemDecoration(itemDecoration);
    }
}
