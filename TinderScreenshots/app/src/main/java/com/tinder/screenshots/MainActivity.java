package com.tinder.screenshots;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;

    DatabaseReference mFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        //pushDataToDB();

    }//onCreate


    private void pushDataToDB()
    {
        Log.d(TAG, "pushDataToDB: ");

        ArrayList<String> urls = new ArrayList<>();




        mFirebaseRef = FirebaseDatabase.getInstance().getReference().child("screen-shots");

        for( String url: urls)
        {
            mFirebaseRef.push().setValue(url);
        }//for





    }//pushDataToDB

    private void readData()
    {
        Log.d(TAG, "readData: ");

        final ArrayList<String> urls = new ArrayList<>();

        DatabaseReference mFirebaseDBref;
        mFirebaseDBref = FirebaseDatabase.getInstance().getReference().child("screen-shots");
        mFirebaseDBref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Log.d(TAG, "onDataChange: ");

                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    Log.d(TAG, "onDataChange: URL: "+snapshot.getValue());

                    urls.add(String.valueOf(snapshot.getValue()));

                }//for

                Log.d(TAG, "onDataChange: URLs: "+ urls);

                mRecyclerView = findViewById(R.id.recycler_view);

                mGridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
                mGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, urls);
                mRecyclerView.setAdapter(customAdapter);
            }//onDataChange

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }//onCancelled
        });
    }//readData()

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        readData();
    }
}//main
