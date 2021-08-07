package com.example.madpractical2_activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UsersViewHolder extends RecyclerView.ViewHolder {
    TextView txtTitle;
    TextView txtDesc;
    ImageView image;
    public UsersViewHolder(View itemview){
        super(itemview);
        txtTitle = itemView.findViewById(R.id.textView3);
        txtDesc = itemView.findViewById(R.id.textView4);
        image = itemView.findViewById(R.id.imageView2);
    }
}
