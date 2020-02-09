package com.tinder.screenshots;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    private ArrayList personNames;
    private ArrayList personImages;
    private Context context;

    public CustomAdapter(Context context, ArrayList personImages)
    {
        this.context = context;
        this.personImages = personImages;

    }//CustomAdapter


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_row_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);

        return vh;

    }//onCreateViewHolder


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {


        //holder.image.setImageResource((Integer) personImages.get(position));

        Glide.with(holder.image.getContext()).load(personImages.get(position)).into(holder.image);


        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", (String) personImages.get(position));
                context.startActivity(intent);
            }
        });

    }//onBindViewHolder


    @Override
    public int getItemCount()
    {

        return personImages.size();

    }//getItemCount


    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView image;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image);

        }//MyViewHolder

    }//MyViewHolder

}//CustomAdapter
