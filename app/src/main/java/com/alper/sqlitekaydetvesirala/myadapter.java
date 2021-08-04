package com.alper.sqlitekaydetvesirala;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<Oyuncular> oyuncularArrayList;

    public myadapter(ArrayList<Oyuncular> oyuncularArrayList) {
        this.oyuncularArrayList = oyuncularArrayList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.name.setText(oyuncularArrayList.get(position).getName());
        holder.score.setText(oyuncularArrayList.get(position).getScore());
        //holder.id.setText(oyuncularArrayList.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return oyuncularArrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView name,score,id;
        LinearLayout mainLayout;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.displayname);
            score = itemView.findViewById(R.id.displayscore);
            id = itemView.findViewById(R.id.displayid);
            mainLayout = itemView.findViewById(R.id.linearlayout);

        }
    }
}
