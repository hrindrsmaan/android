package com.tinder.screenshots;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    private ArrayList personNames;
    private ArrayList personImages;
    private Context context;

    public CustomAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        // set the data in items
        holder.name.setText("Maan");
        holder.image.setImageResource((Integer) personImages.get(position));

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", (Integer) personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }


    @Override
    public int getItemCount()
    {
        return personNames.size();
    }//getItemCount

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView)
        {
            super(itemView);


            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }//MyViewHolder

    }//MyViewHolder

}//CustomAdapter
