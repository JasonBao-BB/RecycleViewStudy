package com.example.customrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/7 0007.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter {

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView job;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.recycle_view_item_header);
            job = (TextView) itemView.findViewById(R.id.recycle_view_item_content);
        }

        public TextView getJob() {
            return job;
        }

        public TextView getName() {
            return name;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item_cell,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        RecycleItemData data = datas[position];
        viewHolder.getJob().setText(data.job);
        viewHolder.getName().setText(data.name);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    public RecycleItemData[] datas = new RecycleItemData[] {
            new RecycleItemData("Bob","Manager"),
            new RecycleItemData("Jason","Student"),
            new RecycleItemData("Jiawei","Farmer"),
            new RecycleItemData("Jax","Teacher")};
}
