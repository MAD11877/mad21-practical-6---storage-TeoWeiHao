package com.example.madpractical2_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    ArrayList<User> data;

    public UsersAdapter(ArrayList<User> input){
        data = input;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.rv_item7,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.rv_item,
                    parent,
                    false
            );
        }
        return new UsersViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).name.substring(data.get(position).name.length()-1));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User u = data.get(position);
        holder.txtTitle.setText(u.getName());
        holder.txtDesc.setText(u.getDescription());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(holder.image.getContext())
                        .setTitle("Profile")
                        .setMessage(u.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent openMain = new Intent(holder.image.getContext(), MainActivity.class);
                                openMain.putExtra("id", u.getId());
                                holder.image.getContext().startActivity(openMain);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
