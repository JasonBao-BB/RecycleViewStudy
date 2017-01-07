package com.example.administrator.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {

            class myViewHolder extends RecyclerView.ViewHolder{

                private TextView textView;
                public myViewHolder(TextView itemView) {
                    super(itemView);
                    textView = itemView;
                }

                public TextView getTextView() {
                    return textView;
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                //为RecycleView添加一个父布局，可以在自定义ViewHolder里面添加子布局
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_test_item,null);
                return new myViewHolder(new TextView(getApplicationContext()));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                myViewHolder viewHolder = (myViewHolder) holder;
                viewHolder.getTextView().setText("Item "+ position);
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }
}
