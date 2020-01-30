package com.tinder.screenshots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;



    private void setupWidgets()
    {
        Log.d(TAG, "setupWidgets: ");

        mRecyclerView = findViewById(R.id.recycler_view);
        mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        mGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }//setupWidgets

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        setupWidgets();

        mRecyclerView.setLayoutManager(mGridLayoutManager);

        ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
        ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7,R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7));

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, personNames, personImages);
        mRecyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

    }//onCreate
}
