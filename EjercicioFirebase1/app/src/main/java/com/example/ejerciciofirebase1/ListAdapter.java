package com.example.ejerciciofirebase1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
//
    public ListAdapter(List<ListElement> itemList, Context context) {
        this.mData = itemList;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }



    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
    holder.bindData(mData.get(position));
    }






    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems (List<ListElement> items){
        mData =  items;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name, email;
        ImageView iconImage;

        public ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            email = itemView.findViewById(R.id.mailTextView);

        }

        void bindData(final ListElement item){

            name.setText(item.getNombre());
            email.setText(item.getEmail());

        }


    }




}